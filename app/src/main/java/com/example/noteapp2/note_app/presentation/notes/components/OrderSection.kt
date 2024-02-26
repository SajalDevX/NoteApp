package com.example.noteapp2.note_app.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp2.note_app.domain.util.NoteOrder
import com.example.noteapp2.note_app.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {

        DefaultRadioButton(
            text = "Title Ascending",
            selected = noteOrder is NoteOrder.Title && noteOrder.orderType == OrderType.Ascending,
            onSelect = { onOrderChange(NoteOrder.Title(OrderType.Ascending)) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultRadioButton(
            text = "Title Descending",
            selected = noteOrder is NoteOrder.Title && noteOrder.orderType == OrderType.Descending,
            onSelect = { onOrderChange(NoteOrder.Title(OrderType.Descending)) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DefaultRadioButton(
            text = "Date Ascending",
            selected = noteOrder is NoteOrder.Date && noteOrder.orderType == OrderType.Ascending,
            onSelect = { onOrderChange(NoteOrder.Date(OrderType.Ascending)) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultRadioButton(
            text = "Date Descending",
            selected = noteOrder is NoteOrder.Date && noteOrder.orderType == OrderType.Descending,
            onSelect = { onOrderChange(NoteOrder.Date(OrderType.Descending)) }
        )

    }

}


//@Composable
//fun OrderSection(
//    modifier: Modifier = Modifier,
//    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
//    onOrderChange: (NoteOrder) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = modifier
//    ) {
//        Box {
//            BasicTextField(
//                value = "",
//                onValueChange = {},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//                    .clickable { expanded = !expanded },
//                enabled = false,
//                decorationBox = { innerTextField ->
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = "Sort by: ",
//                            modifier = Modifier.weight(1f)
//                        )
//                        Icon(
//                            imageVector = Icons.Default.ArrowDropDown,
//                            contentDescription = "Sort order",
//                            tint = MaterialTheme.colorScheme.onSurface
//                        )
//                    }
//                }
//            )
//
//            DropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                DropdownMenuItem(
//                    text = {
//                        Text("Title")
//                    },
//                    onClick = {
//                        onOrderChange(NoteOrder.Title(noteOrder.orderType))
//                        expanded = false
//                    })
//
//                DropdownMenuItem(
//                    text = {
//                        Text("Date")
//                    }, onClick = {
//                        onOrderChange(NoteOrder.Date(noteOrder.orderType))
//                        expanded = false
//                    })
//
//                DropdownMenuItem(
//                    text = {
//                        Text("Ascending")
//                    }, onClick = {
//                        onOrderChange(noteOrder.copy(OrderType.Ascending))
//                        expanded = false
//                    })
//
//                DropdownMenuItem(text = {
//                    Text("Descending")
//                }, onClick = {
//                    onOrderChange(noteOrder.copy(OrderType.Descending))
//                    expanded = false
//                })
//            }
//        }
//    }
//}