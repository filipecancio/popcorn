package dev.cancio.popcorn.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.cancio.popcorn.data.dao.PopCornDao
import dev.cancio.popcorn.data.model.entity.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class PopcornDatabase : RoomDatabase()  {

    abstract fun popCornDao(): PopCornDao

    companion object {
        @Volatile
        private var INSTANCE: PopcornDatabase? = null

        fun getDatabase(context: Context): PopcornDatabase =INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PopcornDatabase::class.java,
                "PopCorn_database"
            ).build()
            INSTANCE = instance

            instance
        }
    }
}