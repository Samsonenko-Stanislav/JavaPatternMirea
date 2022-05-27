package com.example.Task17.services;

import com.example.Task17.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    private EmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailService(javaMailSenderImpl);
    }

    @Test
    void sendNotification() {

        // given
        Game game = new Game();
        game.setName("Zuma");
        game.setCreationDate(1997);
        Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        // when
        underTest.sendNotification(game);

        // then
        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));



    }
}