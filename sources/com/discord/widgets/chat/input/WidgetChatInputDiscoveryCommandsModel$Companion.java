package com.discord.widgets.chat.input;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandKt;
import com.discord.models.commands.ModelApplicationComparator;
import com.discord.stores.DiscoverCommands;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandLoadingPlaceholder;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatInputDiscoveryCommandsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputDiscoveryCommandsModel$Companion {
    private WidgetChatInputDiscoveryCommandsModel$Companion() {
    }

    private final List<Autocompletable> createPlaceholderModels(int placeholdersCount, Application app) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < placeholdersCount; i++) {
            arrayList.add(i, new ApplicationCommandLoadingPlaceholder(app));
        }
        return arrayList;
    }

    public final WidgetChatInputDiscoveryCommandsModel parseModelDiscoveryCommands(long myId, List<Long> myRoles, List<Application> applications, DiscoverCommands discoveryCommands, boolean includeHeaders, int placeholdersCount, List<? extends ApplicationCommand> frecencyCommands) {
        m.checkNotNullParameter(myRoles, "myRoles");
        m.checkNotNullParameter(applications, "applications");
        m.checkNotNullParameter(discoveryCommands, "discoveryCommands");
        m.checkNotNullParameter(frecencyCommands, "frecencyCommands");
        HashMap map = new HashMap();
        for (Application application : applications) {
            map.put(Long.valueOf(application.getId()), application);
        }
        TreeSet<Application> treeSet = new TreeSet(ModelApplicationComparator.Companion);
        HashMap map2 = new HashMap();
        for (ApplicationCommand applicationCommand : discoveryCommands.getCommands()) {
            long applicationId = applicationCommand.getApplicationId();
            Application application2 = (Application) map.get(Long.valueOf(applicationId));
            if (application2 != null) {
                m.checkNotNullExpressionValue(application2, "appMap[appId] ?: continue");
                treeSet.add(application2);
                ApplicationCommandAutocompletable applicationCommandAutocompletable = new ApplicationCommandAutocompletable(application2, applicationCommand, ApplicationCommandKt.hasPermission(applicationCommand, myId, myRoles), false);
                if (map2.containsKey(Long.valueOf(applicationId))) {
                    List list = (List) map2.get(Long.valueOf(applicationId));
                    if (list != null) {
                        list.add(applicationCommandAutocompletable);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(applicationCommandAutocompletable);
                    map2.put(Long.valueOf(applicationId), arrayList);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Application application3 : treeSet) {
            List list2 = (List) map2.get(Long.valueOf(application3.getId()));
            if (list2 != null && (true ^ list2.isEmpty())) {
                if (includeHeaders) {
                    list2.add(0, new ApplicationPlaceholder(application3));
                }
                arrayList2.add(new Pair(application3, list2));
            }
        }
        if (placeholdersCount > 0 && (!arrayList2.isEmpty())) {
            if (discoveryCommands.getHasMoreBefore()) {
                Pair pair = (Pair) u.first((List) arrayList2);
                Application application4 = (Application) pair.component1();
                arrayList2.set(0, new Pair(application4, u.plus((Collection) createPlaceholderModels(placeholdersCount, application4), (Iterable) pair.component2())));
            }
            if (discoveryCommands.getHasMoreAfter()) {
                Pair pair2 = (Pair) u.last((List) arrayList2);
                Application application5 = (Application) pair2.component1();
                arrayList2.set(arrayList2.size() - 1, new Pair(application5, u.plus((Collection) pair2.component2(), (Iterable) createPlaceholderModels(placeholdersCount, application5))));
            }
        }
        Application application6 = (Application) map.get(-2L);
        if (!discoveryCommands.getHasMoreBefore() && application6 != null && (!frecencyCommands.isEmpty())) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new ApplicationPlaceholder(application6));
            for (ApplicationCommand applicationCommand2 : frecencyCommands) {
                Application application7 = (Application) map.get(Long.valueOf(applicationCommand2.getApplicationId()));
                if (application7 != null) {
                    m.checkNotNullExpressionValue(application7, "appMap[command.applicationId] ?: return@forEach");
                    arrayList3.add(new ApplicationCommandAutocompletable(application7, applicationCommand2, ApplicationCommandKt.hasPermission(applicationCommand2, myId, myRoles), true));
                }
            }
            arrayList2.add(0, new Pair(application6, arrayList3));
        }
        return new WidgetChatInputDiscoveryCommandsModel(arrayList2, discoveryCommands.getHasMoreBefore(), discoveryCommands.getHasMoreAfter(), discoveryCommands.getJumpedSequenceId(), discoveryCommands.getJumpedApplicationId(), discoveryCommands.getLoadState());
    }

    public /* synthetic */ WidgetChatInputDiscoveryCommandsModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
