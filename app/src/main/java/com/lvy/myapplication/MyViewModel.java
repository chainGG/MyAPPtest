package com.lvy.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer>  aTeamScore;
    private MutableLiveData<Integer>  bTeamScore;
    private Integer aLast;
    private Integer bLast;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore==null){
            aTeamScore= new MutableLiveData<>();
            aTeamScore.setValue(0);
        }

        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore==null){
            bTeamScore= new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }


    public void ateamAdd(int i){
        saveLastScore();
        aTeamScore.setValue(aTeamScore.getValue()+i);
    }

    public void bteamAdd(int i){
        saveLastScore();
        bTeamScore.setValue(bTeamScore.getValue()+i);
    }

    public void undo(){
        aTeamScore.setValue(aLast);
        bTeamScore.setValue(bLast);

    }

    public void reset(){
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    private  void saveLastScore(){
        this.aLast=aTeamScore.getValue();
        this.bLast=bTeamScore.getValue();
    }

}
