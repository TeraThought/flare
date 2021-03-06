package enchant.flare

import cocoapods.FirebaseCore.FIRApp
import cocoapods.FirebaseCore.FIROptions

actual class FirebaseApp(val app: FIRApp) {
    actual val name: String = app.name
    actual val options: FirebaseOptions = toFirebaseOptions(app.options)

    actual companion object {
        actual val instance: FirebaseApp by lazy { FirebaseApp(FIRApp.defaultApp()!!) }

        actual fun getApps(context: Any?): List<FirebaseApp> =
            FIRApp.allApps?.values?.map { FirebaseApp(it as FIRApp) } ?: emptyList()

        actual fun getInstance(name: String): FirebaseApp =
            FirebaseApp(FIRApp.appNamed(name)!!)

        actual fun initialize(context: Any?, name: String?, options: FirebaseOptions?) {
            when (true) {
                name == null && options == null -> FIRApp.configure()
                name == null -> FIRApp.configureWithOptions(toFIROptions(options!!))
                else -> FIRApp.configureWithName(name, toFIROptions(options!!))
            }
        }
    }
}

private fun toFirebaseOptions(options: FIROptions): FirebaseOptions =
    FirebaseOptions(
        apiKey = options.APIKey!!,
        appId = options.googleAppID,
        databaseUrl = options.databaseURL,
        gcmSenderId = options.GCMSenderID,
        projectId = options.projectID,
        measurementId = options.trackingID,
        storageBucket = options.storageBucket,
        bundleId = options.bundleID,
        clientId = options.clientID
    )

private fun toFIROptions(options: FirebaseOptions): FIROptions =
    FIROptions(options.appId, options.gcmSenderId!!).apply {
        setAPIKey(options.apiKey)
        setAndroidClientID(options.androidClientId!!)
        setDatabaseURL(options.databaseUrl)
        setProjectID(options.projectId)
        setTrackingID(options.measurementId)
        setStorageBucket(options.storageBucket)
        setBundleID(bundleID)
        setClientID(clientID)
    }