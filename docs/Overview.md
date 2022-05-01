# Overview

Learn a little bit more about Flare's firey APIs

## Firebase Firestore

Flare's Firebase Firestore command allows for the reading, writing, and deleting of documents to be seamless and easy to use.
There are a couple functions you can call to edit a document. SetDocument, GetDocumentOnce, and println() are all functions used to
read, write, and display data values. You can find the Firebase documentation for Firestore [here](https://cloud.google.com/firestore/docs/manage-data/add-data)

```kotlin
suspend fun main() {

    @Serializable
    data class Dog( // Class created to store id, name, age and string that is being written to the document
        @SerialName(DocId)
        val id: String,
        val name: String,
        val age: Int
    )

    // Calling Local Firestore to read and write in a document
    val firestore = LocalFirestore()
    val writeDog = Dog("a3f6awe9", "Max", Int.MAX_VALUE)
    firestore.setDocument("dogs/${writeDog.id}", writeDog) // Adds the writeDog variable to the document
    // Specified by the path given
    val readDog: Dog = firestore.getDocumentOnce("dogs/${writeDog.id}").data() // Reads what is in the document
    // (Once again specified by the path given)
    println(readDog)
}
```

## Firebase Auth

Firebase Auth is used for the authentification and identification of who someone is. It can help with creating an account,
signing into an account, signing out, and deleting the account. Creating an account by calling a couple functions
makes the authentication experience much more efficient for developers. You can find the Firebase documentation for
Auth [here](https://firebase.google.com/docs/auth/web/manage-users)

```kotlin
suspend fun main() {

    @Serializable
    data class Dog( // Class created to store id, name, age and string that is being written to the document
        @SerialName(DocId)
        val id: String,
        val name: String,
        val age: Int
    )

    // Sign in, sign out, sign back in, delete account
    val auth = LocalAuth()

    val method: AuthMethod = AuthMethod.EmailPassword(email = "johnnyappleseed@pear.com", password = "johnny123")
    auth.signIn(method) // Signs in using the method variable that is given - contains email and password of the user
    auth.signOut()
    auth.signIn(method) // Signs in once again using the method variable
    auth.currentUser!!.delete()   // Deletes the account if the user is registered and logged in
}
```

## Firebase Storage

Firebase Storage is used to manage files. By calling the LocalStorage() library you are able to
use a couple functions to manipulate and organize files in a readable manner. You can find the
Firebase documentation for Storage [here](https://firebase.google.com/docs/storage)


```kotlin
suspend fun main() {

    // Writing, reading, and deleting a file
    val storage = LocalStorage()
    val message = "Framework engineering is the best"
    val byteArray = message.encodeToByteArray()
    storage.putBytes("messages/message1.txt", byteArray) // Stores the byte array away in the file that was
    // Specified by the user - in this case storing it in "messages/message1.txt"

    val bytes = storage.getBytes("messages/message1.txt", byteArray.size.toLong()) // Reads the byte array
    // And converts the bytes to a string which then is printed out for everyone to see
    println(bytes.decodeToString())

    storage.deleteFile("messages/message1.txt") // Deletes the file "messages/message1.txt"
}
```