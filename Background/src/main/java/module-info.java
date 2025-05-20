module Background {
    requires Common;
    requires javafx.graphics;
    provides dk.sdu.cbse.common.services.IBackgroundService with dk.sdu.cbse.backgroundelement.BackgroundProcessor;
}