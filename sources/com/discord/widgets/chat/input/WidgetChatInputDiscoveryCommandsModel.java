package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.stores.DiscoverCommands;
import com.discord.stores.LoadState;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: WidgetChatInputDiscoveryCommandsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatInputDiscoveryCommandsModel {
    public static final WidgetChatInputDiscoveryCommandsModel$Companion Companion = new WidgetChatInputDiscoveryCommandsModel$Companion(null);
    private final List<Pair<Application, List<Autocompletable>>> commandsByApplication;
    private final boolean hasMoreAfter;
    private final boolean hasMoreBefore;
    private final Long jumpedApplicationId;
    private final int jumpedSequenceId;
    private final LoadState loadState;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputDiscoveryCommandsModel(List<? extends Pair<Application, ? extends List<? extends Autocompletable>>> list, boolean z2, boolean z3, int i, Long l, LoadState loadState) {
        m.checkNotNullParameter(list, "commandsByApplication");
        m.checkNotNullParameter(loadState, "loadState");
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
        return Companion.parseModelDiscoveryCommands(j, list, list2, discoverCommands, z2, i, list3);
    }

    public final List<Pair<Application, List<Autocompletable>>> component1() {
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

    public final WidgetChatInputDiscoveryCommandsModel copy(List<? extends Pair<Application, ? extends List<? extends Autocompletable>>> commandsByApplication, boolean hasMoreBefore, boolean hasMoreAfter, int jumpedSequenceId, Long jumpedApplicationId, LoadState loadState) {
        m.checkNotNullParameter(commandsByApplication, "commandsByApplication");
        m.checkNotNullParameter(loadState, "loadState");
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
        return m.areEqual(this.commandsByApplication, widgetChatInputDiscoveryCommandsModel.commandsByApplication) && this.hasMoreBefore == widgetChatInputDiscoveryCommandsModel.hasMoreBefore && this.hasMoreAfter == widgetChatInputDiscoveryCommandsModel.hasMoreAfter && this.jumpedSequenceId == widgetChatInputDiscoveryCommandsModel.jumpedSequenceId && m.areEqual(this.jumpedApplicationId, widgetChatInputDiscoveryCommandsModel.jumpedApplicationId) && m.areEqual(this.loadState, widgetChatInputDiscoveryCommandsModel.loadState);
    }

    public final List<Pair<Application, List<Autocompletable>>> getCommandsByApplication() {
        return this.commandsByApplication;
    }

    public final List<Autocompletable> getFlattenCommandsModel() {
        ArrayList arrayList = new ArrayList();
        Iterator<Pair<Application, List<Autocompletable>>> it = this.commandsByApplication.iterator();
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
        List<Pair<Application, List<Autocompletable>>> list = this.commandsByApplication;
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
        StringBuilder sbU = a.U("WidgetChatInputDiscoveryCommandsModel(commandsByApplication=");
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
