package utilities;

import exceptions.NotEnoughMoneyException;

public interface LoseAll {
    void loseProperty();
    void loseMoney(int m) throws NotEnoughMoneyException;
}
