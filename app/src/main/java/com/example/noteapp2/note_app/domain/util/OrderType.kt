package com.example.noteapp2.note_app.domain.util

sealed class OrderType {
    object Ascending:OrderType()
    object Descending:OrderType()
}