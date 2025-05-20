package dk.sdu.cbse.backgroundelement;

import dk.sdu.cbse.common.services.IBackgroundService;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;

public class BackgroundProcessor implements IBackgroundService{
    @Override
    public void setBackground(Pane pane) {
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, Insets.EMPTY)));
    }
}
