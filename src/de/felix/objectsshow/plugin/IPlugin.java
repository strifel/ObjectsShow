package de.felix.objectsshow.plugin;

public interface IPlugin {
    Double getManagerVersion();

    String getName();

    void enablePlugin(PluginManager pluginManager) throws Exception;

    void disablePlugin();


}
