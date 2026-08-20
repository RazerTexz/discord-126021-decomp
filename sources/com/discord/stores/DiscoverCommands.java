package com.discord.stores;

import com.discord.models.commands.ApplicationCommand;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DiscoverCommands {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ApplicationCommand> commands;
    private final int currentEndOffset;
    private final int currentStartOffset;
    private final boolean hasMoreAfter;
    private final boolean hasMoreBefore;
    private final Long jumpedApplicationId;
    private final int jumpedSequenceId;
    private final LoadState loadState;

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DiscoverCommands getDefaultModelDiscoveryCommands() {
            return new DiscoverCommands(C12147n.emptyList(), 0, 0, false, false, 0, null, null, 128, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoverCommands(List<? extends ApplicationCommand> list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState) {
        C12238m.checkNotNullParameter(list, "commands");
        C12238m.checkNotNullParameter(loadState, "loadState");
        this.commands = list;
        this.currentStartOffset = i;
        this.currentEndOffset = i2;
        this.hasMoreBefore = z2;
        this.hasMoreAfter = z3;
        this.jumpedSequenceId = i3;
        this.jumpedApplicationId = l;
        this.loadState = loadState;
    }

    public final List<ApplicationCommand> component1() {
        return this.commands;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final LoadState getLoadState() {
        return this.loadState;
    }

    public final DiscoverCommands copy(List<? extends ApplicationCommand> commands, int currentStartOffset, int currentEndOffset, boolean hasMoreBefore, boolean hasMoreAfter, int jumpedSequenceId, Long jumpedApplicationId, LoadState loadState) {
        C12238m.checkNotNullParameter(commands, "commands");
        C12238m.checkNotNullParameter(loadState, "loadState");
        return new DiscoverCommands(commands, currentStartOffset, currentEndOffset, hasMoreBefore, hasMoreAfter, jumpedSequenceId, jumpedApplicationId, loadState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoverCommands)) {
            return false;
        }
        DiscoverCommands discoverCommands = (DiscoverCommands) other;
        return C12238m.areEqual(this.commands, discoverCommands.commands) && this.currentStartOffset == discoverCommands.currentStartOffset && this.currentEndOffset == discoverCommands.currentEndOffset && this.hasMoreBefore == discoverCommands.hasMoreBefore && this.hasMoreAfter == discoverCommands.hasMoreAfter && this.jumpedSequenceId == discoverCommands.jumpedSequenceId && C12238m.areEqual(this.jumpedApplicationId, discoverCommands.jumpedApplicationId) && C12238m.areEqual(this.loadState, discoverCommands.loadState);
    }

    public final List<ApplicationCommand> getCommands() {
        return this.commands;
    }

    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
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
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<ApplicationCommand> list = this.commands;
        int iHashCode = (((((list != null ? list.hashCode() : 0) * 31) + this.currentStartOffset) * 31) + this.currentEndOffset) * 31;
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
        StringBuilder sbM833U = C1643a.m833U("DiscoverCommands(commands=");
        sbM833U.append(this.commands);
        sbM833U.append(", currentStartOffset=");
        sbM833U.append(this.currentStartOffset);
        sbM833U.append(", currentEndOffset=");
        sbM833U.append(this.currentEndOffset);
        sbM833U.append(", hasMoreBefore=");
        sbM833U.append(this.hasMoreBefore);
        sbM833U.append(", hasMoreAfter=");
        sbM833U.append(this.hasMoreAfter);
        sbM833U.append(", jumpedSequenceId=");
        sbM833U.append(this.jumpedSequenceId);
        sbM833U.append(", jumpedApplicationId=");
        sbM833U.append(this.jumpedApplicationId);
        sbM833U.append(", loadState=");
        sbM833U.append(this.loadState);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ DiscoverCommands(List list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, z2, z3, i3, l, (i4 & 128) != 0 ? LoadState.None.INSTANCE : loadState);
    }
}
