package com.example.navdetails.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.AsyncImage
import com.example.navdetails.model.Menu
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerScreen(viewModel: NavigationViewModel) {
    val userPhoto = viewModel.userPhoto.collectAsState()
    val userName = viewModel.userName.collectAsState()
    val menuList = viewModel.menus.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    val systemUiController = rememberSystemUiController()
    val lightGrey = Color(0xFFF0F0F0)
    SideEffect {
        systemUiController.setStatusBarColor(lightGrey)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Menu",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = RoundedCornerShape(20.dp),
                                color = lightGrey
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccountBox,
                                        contentDescription = "Country",
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "IND-INR-EN",
                                        fontSize = 12.sp,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))

                                        Icon(
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "Dropdown",
                                            tint = Color.Black,
                                            modifier = Modifier.size(16.dp)
                                        )
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            IconButton(
                                onClick = { /* TODO: search click */ },
                                modifier = Modifier.background(lightGrey, shape = CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = Color.Black

                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightGrey)
            )
        },
        containerColor = lightGrey,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /* TODO: Rate us action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rate Us",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Rate Us")
                }
                OutlinedButton(
                    onClick = { /* TODO: Sign out action */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color.Red)
                ) {
                    Text("Sign Out", color = Color.Red)
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(3.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = rememberAsyncImagePainter(userPhoto.value),
                                contentDescription = "User Photo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = userName.value,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                color = Color.Black
                            )
                        }

                        Text(
                            text = "Edit Profile",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
            }


            SectionedMenuList(
                menus = menuList.value,
                expanded = expanded,
                onSeeMore = { expanded = true }
            )

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
fun SectionedMenuList(
    menus: List<Menu>,
    expanded: Boolean,
    onSeeMore: () -> Unit
) {
    val sections = mutableListOf<Pair<String, List<Menu>>>()
    var currentHeading = ""
    var currentGrid = mutableListOf<Menu>()
    menus.forEach { menu ->
        when (menu.type) {
            0 -> {
                if (currentGrid.isNotEmpty() && currentHeading.isNotEmpty()) {
                    sections.add(currentHeading to currentGrid.toList())
                    currentGrid = mutableListOf()
                }
                currentHeading = menu.label
            }
            1 -> {
                currentGrid.add(menu)
            }
        }
    }
    if (currentGrid.isNotEmpty() && currentHeading.isNotEmpty()) {
        sections.add(currentHeading to currentGrid.toList())
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        sections.forEach { (heading, gridItems) ->
            Text(
                text = heading,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
            if (heading.equals("APPS", ignoreCase = true)) {
                val showItems = if (expanded || gridItems.size <= 4) gridItems else gridItems.take(4)
                MenuGrid(showItems)
                if (!expanded && gridItems.size > 4) {
                    Button(
                        onClick = onSeeMore,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD3D3D3))
                    ) {
                        Text("See More", color = Color(0xFF000000))
                    }
                }
            } else if (heading.equals("HELP & MORE", ignoreCase = true)) {
                val showItems = if (gridItems.size <= 4) gridItems else gridItems.take(4)
                MenuGrid(showItems)
            } else if (heading.equals("FAVOURITES", ignoreCase = true)) {
                val showItems = if (gridItems.size <= 2) gridItems else gridItems.take(2)
                MenuGrid(showItems)
            } else {
                MenuGrid(gridItems)
            }
        }
    }
}

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun MenuGrid(menus: List<Menu>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 300.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(menus) { menu ->
            MenuItem(menu = menu)
        }
    }
}

@Composable
fun MenuItem(menu: Menu) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            menu.icon?.let { iconUrl ->
                AsyncImage(
                    model = iconUrl,
                    contentDescription = menu.label,
                    modifier = Modifier
                        .size(26.dp)
                        .padding(end = 8.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = menu.label,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }
        }
    }
}

