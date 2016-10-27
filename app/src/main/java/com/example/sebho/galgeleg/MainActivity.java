package com.example.sebho.galgeleg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Logic logic = new Logic();
    String word = logic.getOrdet();
    EditText textField;
    TextView visibleWordView, guessedLetters;
    ArrayList<String> guesses;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);

        visibleWordView = (TextView) findViewById(R.id.InvisibleWord);
        visibleWordView.setText(logic.getSynligtOrd());

        guessedLetters = (TextView) findViewById(R.id.guessedLetters);

        textField = (EditText) findViewById(R.id.Guess);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    public void onClick(View view){
        String input = textField.getText().toString();
        int curWrongLetters = logic.getAntalForkerteBogstaver();
        if (!(input.isEmpty()) && input.length() < 2){
            logic.gætBogstav(input);
            textField.setText("");
            int newWrongLetters = logic.getAntalForkerteBogstaver();
            if(curWrongLetters != newWrongLetters){
                switch (newWrongLetters){
                    case 1: image.setImageResource(R.drawable.forkert1);
                            break;
                    case 2: image.setImageResource(R.drawable.forkert2);
                        break;
                    case 3: image.setImageResource(R.drawable.forkert3);
                        break;
                    case 4: image.setImageResource(R.drawable.forkert4);
                        break;
                    case 5: image.setImageResource(R.drawable.forkert5);
                        break;
                    case 6: image.setImageResource(R.drawable.forkert6);
                        break;
                }

            }
            visibleWordView.setText(logic.getSynligtOrd());
            guessedLetters.setText("");
            guesses = logic.getBrugteBogstaver();
            for (int i = 0; i < guesses.size(); i++) {
                guessedLetters.append("<" + guesses.get(i) + "> ");
            }
        }
    }
    public void setGuesses(){

    }
}
