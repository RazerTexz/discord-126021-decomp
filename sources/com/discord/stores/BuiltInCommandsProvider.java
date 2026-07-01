package com.discord.stores;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import java.util.List;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface BuiltInCommandsProvider {
    Application getBuiltInApplication();

    List<ApplicationCommand> getBuiltInCommands();

    Application getFrecencyApplication();
}
