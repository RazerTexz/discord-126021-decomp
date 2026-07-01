package com.discord.widgets.chat.input;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand2;
import com.discord.models.commands.ModelApplicationComparator;
import com.discord.stores.DiscoverCommands;
import com.discord.stores.LoadState;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandLoadingPlaceholder;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatInputDiscoveryCommandsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatInputDiscoveryCommandsModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Tuples2<Application, List<Autocompletable>>> commandsByApplication;
    private final boolean hasMoreAfter;
    private final boolean hasMoreBefore;
    private final Long jumpedApplicationId;
    private final int jumpedSequenceId;
    private final LoadState loadState;

    /* JADX INFO: compiled from: WidgetChatInputDiscoveryCommandsModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final List<Autocompletable> createPlaceholderModels(int placeholdersCount, Application app) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < placeholdersCount; i++) {
                arrayList.add(i, new ApplicationCommandLoadingPlaceholder(app));
            }
            return arrayList;
        }

        public final WidgetChatInputDiscoveryCommandsModel parseModelDiscoveryCommands(long myId, List<Long> myRoles, List<Application> applications, DiscoverCommands discoveryCommands, boolean includeHeaders, int placeholdersCount, List<? extends ApplicationCommand> frecencyCommands) {
            Intrinsics3.checkNotNullParameter(myRoles, "myRoles");
            Intrinsics3.checkNotNullParameter(applications, "applications");
            Intrinsics3.checkNotNullParameter(discoveryCommands, "discoveryCommands");
            Intrinsics3.checkNotNullParameter(frecencyCommands, "frecencyCommands");
            HashMap map = new HashMap();
            for (Application application : applications) {
                map.put(Long.valueOf(application.getId()), application);
            }
            TreeSet<Application> treeSet = new TreeSet(ModelApplicationComparator.INSTANCE);
            HashMap map2 = new HashMap();
            for (ApplicationCommand applicationCommand : discoveryCommands.getCommands()) {
                long applicationId = applicationCommand.getApplicationId();
                Application application2 = (Application) map.get(Long.valueOf(applicationId));
                if (application2 != null) {
                    Intrinsics3.checkNotNullExpressionValue(application2, "appMap[appId] ?: continue");
                    treeSet.add(application2);
                    ApplicationCommandAutocompletable applicationCommandAutocompletable = new ApplicationCommandAutocompletable(application2, applicationCommand, ApplicationCommand2.hasPermission(applicationCommand, myId, myRoles), false);
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
                    arrayList2.add(new Tuples2(application3, list2));
                }
            }
            if (placeholdersCount > 0 && (!arrayList2.isEmpty())) {
                if (discoveryCommands.getHasMoreBefore()) {
                    Tuples2 tuples2 = (Tuples2) _Collections.first((List) arrayList2);
                    Application application4 = (Application) tuples2.component1();
                    arrayList2.set(0, new Tuples2(application4, _Collections.plus((Collection) createPlaceholderModels(placeholdersCount, application4), (Iterable) tuples2.component2())));
                }
                if (discoveryCommands.getHasMoreAfter()) {
                    Tuples2 tuples3 = (Tuples2) _Collections.last((List) arrayList2);
                    Application application5 = (Application) tuples3.component1();
                    arrayList2.set(arrayList2.size() - 1, new Tuples2(application5, _Collections.plus((Collection) tuples3.component2(), (Iterable) createPlaceholderModels(placeholdersCount, application5))));
                }
            }
            Application application6 = (Application) map.get(-2L);
            if (!discoveryCommands.getHasMoreBefore() && application6 != null && (!frecencyCommands.isEmpty())) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(new ApplicationPlaceholder(application6));
                for (ApplicationCommand applicationCommand2 : frecencyCommands) {
                    Application application7 = (Application) map.get(Long.valueOf(applicationCommand2.getApplicationId()));
                    if (application7 != null) {
                        Intrinsics3.checkNotNullExpressionValue(application7, "appMap[command.applicationId] ?: return@forEach");
                        arrayList3.add(new ApplicationCommandAutocompletable(application7, applicationCommand2, ApplicationCommand2.hasPermission(applicationCommand2, myId, myRoles), true));
                    }
                }
                arrayList2.add(0, new Tuples2(application6, arrayList3));
            }
            return new WidgetChatInputDiscoveryCommandsModel(arrayList2, discoveryCommands.getHasMoreBefore(), discoveryCommands.getHasMoreAfter(), discoveryCommands.getJumpedSequenceId(), discoveryCommands.getJumpedApplicationId(), discoveryCommands.getLoadState());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputDiscoveryCommandsModel(List<? extends Tuples2<Application, ? extends List<? extends Autocompletable>>> list, boolean z2, boolean z3, int i, Long l, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(list, "commandsByApplication");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        this.commandsByApplication = list;
        this.hasMoreBefore = z2;
        this.hasMoreAfter = z3;
        this.jumpedSequenceId = i;
        this.jumpedApplicationId = l;
        this.loadState = loadState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatInputDiscoveryCommandsModel copy$default(WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list, boolean z2, boolean z3, int i, Long l, LoadState loadState, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = widgetChatInputDiscoveryCommandsModel.commandsByApplication;
        }
        if ((i2 & 2) != 0) {
            z2 = widgetChatInputDiscoveryCommandsModel.hasMoreBefore;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = widgetChatInputDiscoveryCommandsModel.hasMoreAfter;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            i = widgetChatInputDiscoveryCommandsModel.jumpedSequenceId;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            l = widgetChatInputDiscoveryCommandsModel.jumpedApplicationId;
        }
        Long l2 = l;
        if ((i2 & 32) != 0) {
            loadState = widgetChatInputDiscoveryCommandsModel.loadState;
        }
        return widgetChatInputDiscoveryCommandsModel.copy(list, z4, z5, i3, l2, loadState);
    }

    public static final WidgetChatInputDiscoveryCommandsModel parseModelDiscoveryCommands(long j, List<Long> list, List<Application> list2, DiscoverCommands discoverCommands, boolean z2, int i, List<? extends ApplicationCommand> list3) {
        return INSTANCE.parseModelDiscoveryCommands(j, list, list2, discoverCommands, z2, i, list3);
    }

    public final List<Tuples2<Application, List<Autocompletable>>> component1() {
        return this.commandsByApplication;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final LoadState getLoadState() {
        return this.loadState;
    }

    public final WidgetChatInputDiscoveryCommandsModel copy(List<? extends Tuples2<Application, ? extends List<? extends Autocompletable>>> commandsByApplication, boolean hasMoreBefore, boolean hasMoreAfter, int jumpedSequenceId, Long jumpedApplicationId, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(commandsByApplication, "commandsByApplication");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        return new WidgetChatInputDiscoveryCommandsModel(commandsByApplication, hasMoreBefore, hasMoreAfter, jumpedSequenceId, jumpedApplicationId, loadState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputDiscoveryCommandsModel)) {
            return false;
        }
        WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = (WidgetChatInputDiscoveryCommandsModel) other;
        return Intrinsics3.areEqual(this.commandsByApplication, widgetChatInputDiscoveryCommandsModel.commandsByApplication) && this.hasMoreBefore == widgetChatInputDiscoveryCommandsModel.hasMoreBefore && this.hasMoreAfter == widgetChatInputDiscoveryCommandsModel.hasMoreAfter && this.jumpedSequenceId == widgetChatInputDiscoveryCommandsModel.jumpedSequenceId && Intrinsics3.areEqual(this.jumpedApplicationId, widgetChatInputDiscoveryCommandsModel.jumpedApplicationId) && Intrinsics3.areEqual(this.loadState, widgetChatInputDiscoveryCommandsModel.loadState);
    }

    public final List<Tuples2<Application, List<Autocompletable>>> getCommandsByApplication() {
        return this.commandsByApplication;
    }

    public final List<Autocompletable> getFlattenCommandsModel() {
        ArrayList arrayList = new ArrayList();
        Iterator<Tuples2<Application, List<Autocompletable>>> it = this.commandsByApplication.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().component2());
        }
        return arrayList;
    }

    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    public final LoadState getLoadState() {
        return this.loadState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<Tuples2<Application, List<Autocompletable>>> list = this.commandsByApplication;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMoreBefore;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.hasMoreAfter;
        int i2 = (((i + (z3 ? 1 : z3)) * 31) + this.jumpedSequenceId) * 31;
        Long l = this.jumpedApplicationId;
        int iHashCode2 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        LoadState loadState = this.loadState;
        return iHashCode2 + (loadState != null ? loadState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatInputDiscoveryCommandsModel(commandsByApplication=");
        sbU.append(this.commandsByApplication);
        sbU.append(", hasMoreBefore=");
        sbU.append(this.hasMoreBefore);
        sbU.append(", hasMoreAfter=");
        sbU.append(this.hasMoreAfter);
        sbU.append(", jumpedSequenceId=");
        sbU.append(this.jumpedSequenceId);
        sbU.append(", jumpedApplicationId=");
        sbU.append(this.jumpedApplicationId);
        sbU.append(", loadState=");
        sbU.append(this.loadState);
        sbU.append(")");
        return sbU.toString();
    }
}
