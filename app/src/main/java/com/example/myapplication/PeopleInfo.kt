package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleInfo(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FirstComposeProject", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    titleContentColor = colorResource(R.color.white)
                ),
            )
        }
    ){innerPadding ->
        /*
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Имя: Евгений")
                Text("Отчество: Андреевич")
                Text("Фамилия: Лукашин")
                Text("Мобильный телефон: +7 495 495 95 95")
                Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Имя: Василий")
                Text("Отчество: Егорович")
                Text("Фамилия: Кузякин")
                Text("Мобильный телефон: ---")
                Text("Адрес: Ивановская область, дер. Крутово, д. 4")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Имя: Людмила")
                Text("Отчество: Прокофьевна")
                Text("Фамилия: Калугина")
                Text("Мобильный телефон: +7 495 788 78 78")
                Text("Адрес: Москва, Большая Никитская, д. 43, кв. 290")
            }
        }
         */
        Row( modifier = Modifier
            .padding(innerPadding)
            .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp))
        {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Имя: Евгений")
                Text("Отчество: Андреевич")
                Text("Фамилия: Лукашин")
                Text("Мобильный телефон: +7 495 495 95 95")
                Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
            }
        }
    }
}