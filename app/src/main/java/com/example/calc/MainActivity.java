package com.example.calc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    String math_operation = "0";
    String math_lastOperation;
    TextView math_cont;
    TextView math_LastCont;
    private HorizontalScrollView mathScrollView;
    private HorizontalScrollView mathScrollViewLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AppCompatTextView zero = findViewById(R.id.calc_0);
        AppCompatTextView one = findViewById(R.id.calc_1);
        AppCompatTextView two = findViewById(R.id.calc_2);
        AppCompatTextView three = findViewById(R.id.calc_3);
        AppCompatTextView four = findViewById(R.id.calc_4);
        AppCompatTextView five = findViewById(R.id.calc_5);
        AppCompatTextView six = findViewById(R.id.calc_6);
        AppCompatTextView seven = findViewById(R.id.calc_7);
        AppCompatTextView eight = findViewById(R.id.calc_8);
        AppCompatTextView nine = findViewById(R.id.calc_9);
        AppCompatTextView menu = findViewById(R.id.burger);

        AppCompatTextView scLeft = findViewById(R.id.scLeft);
        AppCompatTextView scRight = findViewById(R.id.scRight);
        AppCompatTextView divide = findViewById(R.id.divide);
        AppCompatTextView minus = findViewById(R.id.minus);
        AppCompatTextView plus = findViewById(R.id.plus);
        AppCompatTextView mul = findViewById(R.id.multiply);
        AppCompatTextView comma = findViewById(R.id.comma);
        AppCompatTextView percent = findViewById(R.id.percent);
        AppCompatTextView degree = findViewById(R.id.degree);
        AppCompatTextView reset = findViewById(R.id.reset);
        AppCompatTextView delete = findViewById(R.id.delete);

        AppCompatTextView equally = findViewById(R.id.equally);

        math_cont = findViewById(R.id.Math_container);
        math_LastCont = findViewById(R.id.Math_lastContainer);

        mathScrollView = findViewById(R.id.math_scroll_view);
        mathScrollViewLast = findViewById(R.id.LastHorizontal);




        menu.setOnClickListener(v -> {
            showMenu();
        });
        zero.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "0";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        one.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "1";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        two.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "2";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        three.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "3";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        four.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "4";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        five.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "5";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        six.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "6";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        seven.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "7";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        eight.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "8";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        nine.setOnClickListener(v -> {
            delNull();
            if (percentbool()) {
                math_operation += "9";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        scLeft.setOnClickListener(v -> {
            if (math_operation.charAt(math_operation.length() - 1) != ')' &&  ("+-*/^".contains(String.valueOf(math_operation.charAt(math_operation.length() - 1))))) {
                math_operation += "(";
            }
            if (math_operation == "0") {
                math_operation = "(";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        scRight.setOnClickListener(v -> {
            if (math_operation.chars().filter(x -> x == '(').count() > math_operation.chars().filter(x -> x == ')').count() && !("(+-*/^.".contains(String.valueOf(math_operation.charAt(math_operation.length() - 1))))) {
                math_operation += ")";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        divide.setOnClickListener(v -> {
            if (!twoSumbol() ) {
                math_operation += "/";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        mul.setOnClickListener(v -> {
            if (!twoSumbol() ) {
                math_operation += "*";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        minus.setOnClickListener(v -> {
            if (!"+-*/^.".contains(String.valueOf(math_operation.charAt(math_operation.length() - 1))) ) {
                math_operation += "-";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        plus.setOnClickListener(v -> {
            if (!twoSumbol() ) {
                math_operation += "+";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        comma.setOnClickListener(v -> {
            if (!hasDecimalInCurrentNumber(math_operation) && !twoSumbol()) {
                math_operation += ".";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        percent.setOnClickListener(v -> {
            if ("1234567890".contains(String.valueOf(math_operation.charAt(math_operation.length() - 1)))) {
                math_operation += "%";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        degree.setOnClickListener(v -> {
            if (!twoSumbol() ) {
                math_operation += "^";
            }
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        reset.setOnClickListener(v -> {
            math_operation = "0";
            math_cont.setText(math_operation);
            updateMathContainer();
        });
        delete.setOnClickListener(v -> {
            if (math_operation.isEmpty() || math_operation.equals("0")) {
                math_operation = "0";
            } else {
                math_operation = math_operation.substring(0, math_operation.length() - 1);
                if (math_operation.isEmpty()) {
                    math_operation = "0";
                }
            }
            updateMathContainer();
        });


        equally.setOnClickListener(v -> {
            math_lastOperation = math_operation;
            math_LastCont.setText(math_lastOperation);
            math_operation = String.valueOf(evaluateExpression(math_operation));
            math_cont.setText(math_operation);
            updateMathContainer();
        });

        math_LastCont.setOnClickListener(v -> {
            math_operation = math_lastOperation;
            math_cont.setText(math_operation);
            math_lastOperation = "";
            math_LastCont.setText(math_lastOperation);

        });

    }
    private void updateMathContainer() {
        math_cont.setText(math_operation);
        mathScrollView.post(() -> {
            mathScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        });
    }

    private void delNull() {
        if (math_operation.equals("0")) {
            math_operation = "";
        }
    }

    private boolean twoSumbol() {
        return "(+-*/^.".contains(String.valueOf(math_operation.charAt(math_operation.length() - 1)));
    }

    private boolean percentbool() {
        if (!math_operation.isEmpty()) {
            return math_operation.charAt(math_operation.length() - 1) != '%';
        }
        else {
            return true;
        }

    }
    public double evaluateExpression(String expression) {
        try {
            Expression e = new Expression(expression);
            double result = e.calculate();
            return result;
        }
        catch (ArithmeticException e) {
            throw new RuntimeException("Ошибка вычисления");
        }

    }
    private boolean hasDecimalInCurrentNumber(String expression) {
        if (expression.isEmpty()) {
            return false;
        }

        int startIndex = 0;
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (i > 0 && (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(')) {
                startIndex = i + 1;
                break;
            }
        }

        String currentNumber = expression.substring(startIndex);

        return currentNumber.contains(".");
    }

    private void showMenu() {
        View menuView = LayoutInflater.from(this).inflate(R.layout.bottom_menu, null);

        AlertDialog bottomMenu = new AlertDialog.Builder(this, R.style.BottomDialogStyle)
                .setView(menuView)
                .create();



        bottomMenu.show();

        Window window = bottomMenu.getWindow();
        if (window != null) {
            window.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );
            window.setGravity(Gravity.BOTTOM);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }





}