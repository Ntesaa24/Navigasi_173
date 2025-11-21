package com.example.prak8.view


import com.example.prak8.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.DividerDefaults.Thickness
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK:List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick : () -> Unit
){
    Scaffold (modifier=Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text=stringResource(id=R.string.home), color =  Color.White)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700))
            )}
    ){ isiRuang ->
        Column(modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(width = 250.dp),
                label = {Text(text = "Nama Lengkap")},
                onValueChange = {},
            )
            HorizontalDivider(modifier = Modifier
                .padding(all=20.dp)
                .width(width=250.dp), thickness = Thickness, color=Color.Red)
            Row{
                jenisK.forEach {
                        item->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = false,
                            onClick = { item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(modifier = Modifier
                .padding(all=20.dp)
                .width(width=250.dp),
                thickness = 1.dp,
                color=Color.Red
            )
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .width(width = 250.dp),
                label = {Text(text = "Alamat")},
                onValueChange = {},
            )
            Spacer(modifier = Modifier.height(height = 30.dp))
            Button(
                modifier = Modifier.fillMaxWidth(1f)
                    .padding(all = 25.dp),
                onClick = OnSubmitBtnClick
            ){
                Text(text = stringResource(id = R.string.submit))

            }

        }
    }
}