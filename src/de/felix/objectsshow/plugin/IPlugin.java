package de.felix.objectsshow.plugin;

import de.felix.objectsshow.exceptions.KeyAlreadyUsedException;

public interface IPlugin {
    Double getManagerVersion();

    String getName();

    void enablePlugin(PluginManager pluginManager) throws KeyAlreadyUsedException;

    void disablePlugin();


}
