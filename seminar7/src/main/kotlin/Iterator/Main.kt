package Iterator

import kotlinx.coroutines.*

class Photo(val name: String)

class PhotoFrame(private val photos: List<Photo>) : Iterator<Photo> {
    private var currentIndex = 0

    override fun hasNext(): Boolean {
        return photos.isNotEmpty()
    }

    override fun next(): Photo {
        val currentPhoto = photos[currentIndex]
        currentIndex = (currentIndex + 1) % photos.size
        return currentPhoto
    }

    suspend fun displayPhotos() {
        while (hasNext()) {
            val photo = next()
            println(photo.name)
            delay(1000L)
        }
    }
}

suspend fun main() {
    val photoFrame = PhotoFrame(listOf(
        Photo("photo1"),
        Photo("photo2"),
        Photo("photo3"),
        Photo("photo4")
    ))
    photoFrame.displayPhotos()
}