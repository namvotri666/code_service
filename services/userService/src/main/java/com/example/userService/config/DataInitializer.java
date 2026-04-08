package com.example.userService.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userService.enity.User;
import com.example.userService.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.count() > 0) {
                System.out.println("⛔ Data already exists, skip init");
                return;
            }

            List<String> names = List.of(
                    "Tuan Khoi", "Minh Anh", "Quang Huy", "Thanh Tung",
                    "Duc Anh", "Bao Chau", "Ngoc Linh", "Hoang Long",
                    "Gia Bao", "Thu Trang");

            Random random = new Random();
            List<User> users = new ArrayList<>();

            for (int i = 1; i <= 100; i++) {

                String name = names.get(random.nextInt(names.size()));

                User user = new User();
                user.setUsername("user" + (1000 + i));
                user.setPassword(passwordEncoder.encode("123456"));

                user.setFullName(name);

                // email theo tên
                String emailName = name.toLowerCase().replace(" ", ".");
                user.setEmail(emailName + i + "@gmail.com");

                // phone random kiểu VN
                user.setPhoneNumber("09" + (10000000 + random.nextInt(90000000)));

                // address fake
                user.setAddress("Ha Noi - Street " + (i + 1));

                // CCCD giả lập 12 số (giống format VN)
                user.setCityzenCode(generateCCCD(random));

                user.setRole("USER");

                users.add(user);
            }

            userRepository.saveAll(users);

            System.out.println("🔥 Inserted " + users.size() + " users");
        };
    }

    // Hàm sinh CCCD 12 số "giống thật"
    private String generateCCCD(Random random) {
        String provinceCode = String.format("%03d", random.nextInt(96) + 1); // mã tỉnh
        String genderYear = String.valueOf(random.nextInt(10)); // giả lập
        String year = String.format("%02d", random.nextInt(100)); // năm sinh
        String randomPart = String.format("%06d", random.nextInt(1000000));

        return provinceCode + genderYear + year + randomPart;
    }
}