package ashish293.learn.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables
    Button[] btn;
    String[] btnStr;
    boolean firstUser;
    int winner;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button resetBtn = findViewById(R.id.btn_reset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        btn = new Button[9];
        btn[0] = findViewById(R.id.btn_0);
        btn[1] = findViewById(R.id.btn_1);
        btn[2] = findViewById(R.id.btn_2);
        btn[3] = findViewById(R.id.btn_3);
        btn[4] = findViewById(R.id.btn_4);
        btn[5] = findViewById(R.id.btn_5);
        btn[6] = findViewById(R.id.btn_6);
        btn[7] = findViewById(R.id.btn_7);
        btn[8] = findViewById(R.id.btn_8);
        firstUser = true;

    }

    public void PlayGame(View view){
        Button curBtn = (Button) view;
        if(curBtn.getText().toString().equals("")){
            if(firstUser){
                curBtn.setText("X");
                firstUser = false;
            }else{
                curBtn.setText("O");
                firstUser = true;
            }
            count++;
        }
        if (firstUser) {
            curBtn.setText("X");
        } else {
            curBtn.setText("O");
        }
        firstUser = !firstUser;

    }

    private void gameOver(){
        TextView winner = findViewById(R.id.tv_winner);
        winner.setText("Winner is " + winner);
        Button resetBtn = findViewById(R.id.btn_reset);
        resetBtn.setVisibility(View.VISIBLE);

    }

    private boolean check() {

        // Check btn
        for (int i = 0; i < 9; i++) {
            btnStr[i] = btn[i].getText().toString();
        }

        // Check Rows and Columns
        for (int i = 0; i < 3; i++) {
            if (btnStr[i * 3 + 0].equals(btnStr[i * 3 + 1]) && btnStr[1].equals(btnStr[i * 3 + 2])) {
                winner = btnStr[i*3].equals("X")?1:2;
                return true;
            }if (btnStr[i + 0].equals(btnStr[i + 3]) && btnStr[1].equals(btnStr[i + 6])) {
                winner = btnStr[i+0].equals("X")?1:2;
                return true;
            }
        }

        // Diagonal Check
        if(btnStr[0].equals(btnStr[4]) && btnStr[4].equals(btnStr[8])){
            winner = btnStr[0].equals("X")?1:2;
            return true;
        }
        if(btnStr[2].equals(btnStr[4]) && btnStr[4].equals(btnStr[6])){
            winner = btnStr[2].equals("X")?1:2;
            return true;
        }
        return false;

    }

    // reset the game
    public void reset(){
        winner = 0;
        for(int i = 0; i < 9; i++){
            btn[i].setText("");
        }
    }
}