package com.example.tarkovnicknamesgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText nickEditText;
    private Button nickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickEditText = findViewById(R.id.nickEditText);
        nickButton = findViewById(R.id.nickButton);

        nickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] keywords = {"Tarkov", "PMC", "Scavenger", "Raid", "Extraction", "Loot",
                        "Gear", "Weapons", "Armor", "Quest", "Survival", "Tactical", "Firefight",
                        "Combat", "Extraction Point", "Secure Container", "Hideout", "Trader",
                        "PMC Operator", "SCAV", "PMC Squad", "Customs", "Shoreline", "Woods",
                        "Factory", "Interchange", "Labs", "Sniper", "Grenade", "Tactical Equipment"};

                Random random = new Random();
                String randomNick = generateRandomNickname(keywords, random);

                nickEditText.setText(randomNick);
            }
        });
    }

    private String generateRandomNickname(String[] keywords, Random random) {
        // Мапа для замены букв цифрами
        Map<Character, Character> letterToNumberMap = new HashMap<>();
        letterToNumberMap.put('A', '4');
        letterToNumberMap.put('B', '8');
        letterToNumberMap.put('E', '3');
        letterToNumberMap.put('I', '1');
        letterToNumberMap.put('L', '1');
        letterToNumberMap.put('O', '0');
        letterToNumberMap.put('S', '5');

        // Выбираем случайное ключевое слово
        String keyword = keywords[random.nextInt(keywords.length)];

        // Добавляем случайный суффикс или префикс
        String[] suffixes = {"er", "ist", "able", "ful", "less"};
        String[] prefixes = {"The", "iAm", "Un", "Re", "In", "Dis"};

        String suffix = "";
        String prefix = "";

        // Генерируем случайное число, чтобы решить, добавлять ли суффикс или оставить строку без него
        int addSuffix = random.nextInt(2);
        if (addSuffix == 1) {
            suffix = suffixes[random.nextInt(suffixes.length)];
        }

        // Генерируем случайное число, чтобы решить, добавлять ли префикс или оставить строку без него
        int addPrefix = random.nextInt(2);
        if (addPrefix == 1) {
            prefix = prefixes[random.nextInt(prefixes.length)];
        }

        // Заменяем буквы цифрами случайным образом
        StringBuilder replacedKeyword = new StringBuilder();
        for (char c : keyword.toCharArray()) {
            if (random.nextBoolean()) {
                Character replacement = letterToNumberMap.get(Character.toUpperCase(c));
                if (replacement != null) {
                    replacedKeyword.append(replacement);
                    continue;
                }
            }
            replacedKeyword.append(c);
        }

        // Объединяем префикс, замененное ключевое слово и суффикс
        String randomNickname = prefix + replacedKeyword.toString() + suffix;

        // Если длина ника превышает 15 символов, обрезаем его
        if (randomNickname.length() > 15) {
            randomNickname = randomNickname.substring(0, 15);
        }

        // Если длина ника меньше 3 символов, добавляем случайный суффикс
        while (randomNickname.length() < 3) {
            randomNickname += suffixes[random.nextInt(suffixes.length)];
        }

        // Удаляем пробелы, если они есть
        randomNickname = randomNickname.replace(" ", "");

        return randomNickname;
    }



}
