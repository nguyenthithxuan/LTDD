package com.example.minitest2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minitest2.ui.theme.Minitest2Theme
import com.google.firebase.firestore.FirebaseFirestore
@OptIn(ExperimentalMaterial3Api::class)
class UpdateCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Minitest2Theme{
                // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Scaffold(
                                // in scaffold we are specifying the top bar.
                                topBar = {
                                    // inside top bar we are specifying
// background color.
                                    TopAppBar(
                                        // along with that we are specifying
// title for our top bar.
                                        title = {
                                            // in the top bar we are specifying
                                            // title as a text
                                            Text(
                                                // on below line we are specifying
// text to display in top app bar
                                                text = "GFG",
// on below line we are specifying
// modifier to fill max width
                                                modifier = Modifier.fillMaxWidth(),
                                                // on below line we are specifying
// text alignment
                                                textAlign = TextAlign.Center,
                                                // on below line we are specifying
                                                // color for our text.
                                                color = Color.White
                                            )
                                        })
                                }) { innerPadding ->
                                Text(
                                    modifier = Modifier.padding(innerPadding),
                                    text = "Cap nhat du lieu."
                                )
                                // on below line getting data from our database
                                // on below line we are calling method to display UI
                                firebaseUI(
                                    LocalContext.current,
                                    intent.getStringExtra("courseName"),
                                    intent.getStringExtra("courseType"),
                                    intent.getStringExtra("coursePrice"),
                                    intent.getStringExtra("courseID"),
                                    intent.getStringExtra("courseImage"),
                                )
                            }
                        }
            }
        }
    }
    // cap nhat
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun firebaseUI(
        context: Context,
        name: String?,
        type: String?,
        price: String?,
        image: String?,
        id: String?,
    ) {
        // on below line creating variable for course name,
        // course duration and course description.
        val courseID = remember {
            mutableStateOf(id)
        }
        val courseName = remember {
            mutableStateOf(name)
        }
        val courseType = remember {
            mutableStateOf(type)
        }
        val coursePrice = remember {
            mutableStateOf(price)
        }
        val courseImage = remember {
            mutableStateOf(image)
        }
        // on below line creating a column
        Column(
            // adding modifier for our column
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White),
            // on below line adding vertical and
            // horizontal alignment for column.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sửa thông tin sản phẩm", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))

            TextField(
                // on below line we are specifying
                // value for our course name text field.
                value = courseName.value.toString(),
                // on below line we are adding on
                // value change for text field.
                onValueChange = { courseName.value = it },
                // on below line we are adding place holder
                // as text as "Enter your course name"
                placeholder = { Text(text = "Hãy nhập tên sản phẩm") },
                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize =
                15.sp),
                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                // on below line we are specifying
                // value for our course duration text field.
                value = courseType.value.toString(),
                // on below line we are adding on
                // value change for text field.
                onValueChange = { courseType.value = it },
                // on below line we are adding place holder
                // as text as "Enter your course duration"
                placeholder = { Text(text = "Hãy nhập loai sản phẩm")
                },
                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize =
                15.sp),
                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                // on below line we are specifying
                // value for our course description text field.
                value = coursePrice.value.toString(),
                // on below line we are adding on
                // value change for text field.
                onValueChange = { coursePrice.value = it },
                // on below line we are adding place holder
                // as text as "Enter your course description"
                placeholder = { Text(text = "Hãy nhập loại sản phẩm") },
                        // on below line we are adding modifier to it
                        // and adding padding to it and filling max width
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize =
                    15.sp),
                    // on below line we are adding
                    // single line to it.
                    singleLine = true,
                )
                    Spacer(modifier = Modifier.height(10.dp))
                    // on below line creating button to add data
                    // to firebase firestore database.
            TextField(
                // on below line we are specifying
                // value for our course duration text field.
                value = courseImage.value.toString(),
                // on below line we are adding on
                // value change for text field.
                onValueChange = { courseImage.value = it },
                // on below line we are adding place holder
                // as text as "Enter your course duration"
                placeholder = { Text(text = "Chọn hình ảnh sản phẩm")
                },
                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize =
                15.sp),
                // on below line we are adding
                // single line to it.
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            // on below line we are validating user input parameters.
                            if (TextUtils.isEmpty(courseName.value.toString())) {
                                Toast.makeText(context, "Hay nhap ten san pham",
                                    Toast.LENGTH_SHORT)
                                    .show()
                            } else if
                                           (TextUtils.isEmpty(courseType.value.toString())) {
                                Toast.makeText(
                                    context,
                                    "Hay nhap loai san pham",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else if
                                           (TextUtils.isEmpty(coursePrice.value.toString())) {
                                Toast.makeText(
                                    context,
                                    "Hay nhap gia san pham",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else if
                                           (TextUtils.isEmpty(courseImage.value.toString())) {
                                Toast.makeText(
                                    context,
                                    "Hay hinh anh san pham",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else {
                                // on below line adding data to
// firebase firestore database.
                                updateDataToFirebase(
                                    courseID.value,
                                    courseName.value,
                                    courseType.value,
                                    coursePrice.value,
                                    courseImage.value,
                                    context
                                )
                            }
                        },
                        // on below line we are
                        // adding modifier to our button.
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // on below line we are adding text for our button
                        Text(text = "Update Data", modifier =
                        Modifier.padding(8.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
        }

    }
private fun updateDataToFirebase(
    id: String?,
    name: String?,
    type: String?,
    price: String?,
    image: String?,
    context: Context
) {
    // inside this method we are passing our updated values
    // inside our object class and later on we
    // will pass our whole object tofirebase Firestore.
    val updatedCourse = Course(id, name, type,price, image)
    // getting our instance from Firebase Firestore.
    val db = FirebaseFirestore.getInstance();

    db.collection("Courses").document(id.toString()).set(updatedCourse)
        .addOnSuccessListener {
            // on below line displaying toast message and opening
            // new activity to view courses.
            Toast.makeText(context, "Course Updated successfully..",
                Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context,
                CourseDetailsActivity::class.java))
            // finish()
        }.addOnFailureListener {
            Toast.makeText(context, "Fail to update course : " +
                    it.message, Toast.LENGTH_SHORT)
                .show()
        }
}



