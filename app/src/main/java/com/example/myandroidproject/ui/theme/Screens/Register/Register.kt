package com.example.myandroidproject.ui.theme.Screens.Register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidproject.Data.UserData
import com.example.myandroidproject.navigation.ROUTE_HOMEPAGE
import com.example.myandroidproject.navigation.ROUTE_LOGIN

//import com.example.firebaseauth.data.AuthViewModel
//import com.example.firebaseauth.navigation.ROUTE_HOME
//import com.example.firebaseauth.navigation.ROUTE_REGISTER
//
//@Composable
//fun RegisterScreen(navController: NavController){
//    Column {
//        Text(
//            text = "PLEASE REGISTER HERE")
//        Spacer(modifier = Modifier.height(25.dp))
//            TextFieldComponent(mylabel = "First Name")
//        Spacer(modifier = Modifier.height(25.dp))
//        TextFieldComponent(mylabel = "Last Name")
//        Spacer(modifier = Modifier.height(25.dp))
//        TextFieldComponent(mylabel = "Location")
//        Spacer(modifier = Modifier.height(25.dp))
//        TextFieldComponent(mylabel = "Password")
//        Spacer(modifier = Modifier.height(25.dp))
//        TextFieldComponent(mylabel = "Confirm password")
//        Spacer(modifier = Modifier.height(25.dp))
//        Spacer(modifier = Modifier.height(25.dp))
//
//
//        Button(onClick = { /*TODO*/ },
//            colors = ButtonDefaults.buttonColors(Color.Green),
//
//
//            ) {
//            Text(
//                modifier = Modifier.padding(10.dp),
//                text = "Register")
//        }
//
//
//
//    }
//
//}
//@Preview(showSystemUi = true, showBackground =true)
//@Composable
//fun RegisterScreenPreview(){
////    RegisterScreen()
//}
//
////@Composable
////fun TextFieldComponent(mylabel: String){
////    var text by remember {
////        mutableStateOf(value = "")
////    }
////    TextField(modifier = Modifier.fillMaxWidth(),
////        value = text, onValueChange = {
////                newText -> text = newText
////        },label = {
////            TextFieldsLabels(value =mylabel)
////
////        }
////
////    )
////}
////@Composable
//fun TextFieldsLabels(value: String){
//    Text(text = value)
//}
//
//@Composable
//fun TextFieldComponent(mylabel: String){
//    var text by remember {
//        mutableStateOf(value = "")
//    }
//    TextField(modifier = Modifier.fillMaxWidth(),
//        value = text, onValueChange = {
//            newText -> text = newText
//        }, label = {
//            TextFieldsLabels(value = mylabel)
//        } )
//}
@Composable
fun RegisterScreen(navController:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White ),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Register here",
            color = Color.Blue,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email") },

            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =confirmpass , onValueChange = {
            confirmpass=it},
            label = { Text(text = "Enter Confirm Pass") },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))



        Button(onClick = {
            val myregister = UserData(navController, context)
            myregister.signup(email.text.trim(), pass.text.trim(),confirmpass.text.trim())
            navController.navigate(ROUTE_HOMEPAGE)




        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an Account? Click to Login")
        }

    }





}

@Composable
fun OutlinedTextField(
    value: Any,
    onValueChange: () -> Unit,
    label: () -> Unit,
    keyboardOptions: Any,
    modifier: Modifier
) {
    TODO("Not yet implemented")
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())

}
