package com.example.testpam52.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testpam52.R
import com.example.testpam52.model.Mahasiswa
import com.example.testpam52.model.RencanaStudy

@Composable
fun TampilDataView(
    mahasiswa : Mahasiswa,
    rencanastudy : RencanaStudy,
    onBackButton: () -> Unit,
    onSplashButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.primary
                )
            )
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(start = 16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.umy
                ),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul dan Islami",
                    color = Color.Red,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column {
                        Text(
                            text = "NIM",
                            fontSize = 20.sp,

                            )
                        Text(
                            text = mahasiswa.nim,
                            fontWeight = FontWeight.Light
                        )

                    }
                    Text(
                        text = mahasiswa.email,
                        fontWeight = FontWeight.Light
                    )
                }

                Column(modifier = Modifier.padding(bottom = 16.dp)) {
                    Text(
                        text = "Nama",
                        fontSize = 20.sp,
                    )
                    Text(
                        text = mahasiswa.nama,
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(modifier = Modifier.padding(top = 50.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Mata Kuliah Yang Diambil :",
                        fontWeight = FontWeight.Light
                    )
                    Text(text = rencanastudy.namaMK)
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Row {
                    Text(
                        text = "Kelas : " + rencanastudy.kelas,
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(modifier = Modifier.padding(top = 30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onBackButton) {
                        Text(text = "Kembali")
                    }
                    Button(onClick = onSplashButton) {
                        Text(text = "Reset")
                    }
                }
            }
        }
    }
}