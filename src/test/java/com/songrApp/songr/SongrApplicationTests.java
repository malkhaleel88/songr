package com.songrApp.songr;

import com.songrApp.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void testConstructor() {
		Album album1 = new Album("Tamally Maak", "Amr Diab", 10, 1500,"https://img.discogs.com/mrVhxSpktswpKo82TcPqv0vK80U=/fit-in/300x300/filters:strip_icc():format(webp):mode_rgb():quality(40)/discogs-images/R-6944106-1500743368-8340.jpeg.jpg");
		album1.setTitle("Aktar Wahed");
		assertEquals("Aktar Wahed",album1.getTitle());
		album1.setArtist("Amr Diab");
		assertEquals("Amr Diab",album1.getArtist());
		album1.setSongCount(9);
		assertEquals(9,album1.getSongCount());
		album1.setLength(3000);
		assertEquals(3000 , album1.getLength());
		album1.setImageUrl("https://img.discogs.com/60vmnABbNLDfwLMosvcyjPsa-cE=/fit-in/600x605/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-10333312-1495486487-7127.jpeg.jpg");
		assertEquals("https://img.discogs.com/60vmnABbNLDfwLMosvcyjPsa-cE=/fit-in/600x605/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-10333312-1495486487-7127.jpeg.jpg",album1.getImageUrl());
	}

}
