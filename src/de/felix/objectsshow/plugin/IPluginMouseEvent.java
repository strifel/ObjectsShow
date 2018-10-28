package de.felix.objectsshow.plugin;

public interface IPluginMouseEvent {
    void mousePressed(int x, int y);

    void mouseReleased(int x, int y);

    void mouseRightClicked(int x, int y);
}
