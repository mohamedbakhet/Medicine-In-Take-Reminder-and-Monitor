package com.Medicine.SkyForceTeam.steps;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.Medicine.SkyForceTeam.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class Stape1 extends Step<String> {
    EditText MadicineName;

    protected Stape1(String title) {
        super(title);
    }

    @Override
    public String getStepData() {

        Editable userName =MadicineName.getText();
        return userName.toString() ;


    }

    @Override
    public String getStepDataAsHumanReadableString() {
        String userName = getStepData();
        return !userName.isEmpty() ? userName : "(Empty)";

    }

    @Override
    public void restoreStepData(String data) {
        MadicineName.setText(data);
    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        MadicineName = new EditText(getContext());
        MadicineName.setSingleLine(true);
        MadicineName.setHint(getString(R.string.some_text));

        MadicineName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Whenever the user updates the user name text, we update the state of the step.
                // The step will be marked as completed only if its data is valid, which will be
                // checked automatically by the form with a call to isStepDataValid().
                markAsCompletedOrUncompleted(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return MadicineName;
    }

    private int getString(int some_text) {
        return 0;
    }

    @Override
    protected void onStepOpened(boolean animated) {

    }

    @Override
    protected void onStepClosed(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }
}
