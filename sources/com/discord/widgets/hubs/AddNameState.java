package com.discord.widgets.hubs;

import com.discord.models.guild.Guild;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddNameState {
    private final RestCallState<Void> changeNicknameAsync;
    private final Guild guild;
    private final String nickname;

    public AddNameState() {
        this(null, null, null, 7, null);
    }

    public AddNameState(String str, Guild guild, RestCallState<Void> restCallState) {
        C12238m.checkNotNullParameter(str, "nickname");
        C12238m.checkNotNullParameter(restCallState, "changeNicknameAsync");
        this.nickname = str;
        this.guild = guild;
        this.changeNicknameAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddNameState copy$default(AddNameState addNameState, String str, Guild guild, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addNameState.nickname;
        }
        if ((i & 2) != 0) {
            guild = addNameState.guild;
        }
        if ((i & 4) != 0) {
            restCallState = addNameState.changeNicknameAsync;
        }
        return addNameState.copy(str, guild, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final RestCallState<Void> component3() {
        return this.changeNicknameAsync;
    }

    public final AddNameState copy(String nickname, Guild guild, RestCallState<Void> changeNicknameAsync) {
        C12238m.checkNotNullParameter(nickname, "nickname");
        C12238m.checkNotNullParameter(changeNicknameAsync, "changeNicknameAsync");
        return new AddNameState(nickname, guild, changeNicknameAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddNameState)) {
            return false;
        }
        AddNameState addNameState = (AddNameState) other;
        return C12238m.areEqual(this.nickname, addNameState.nickname) && C12238m.areEqual(this.guild, addNameState.guild) && C12238m.areEqual(this.changeNicknameAsync, addNameState.changeNicknameAsync);
    }

    public final RestCallState<Void> getChangeNicknameAsync() {
        return this.changeNicknameAsync;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.nickname;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        RestCallState<Void> restCallState = this.changeNicknameAsync;
        return iHashCode2 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AddNameState(nickname=");
        sbM833U.append(this.nickname);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", changeNicknameAsync=");
        sbM833U.append(this.changeNicknameAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ AddNameState(String str, Guild guild, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : guild, (i & 4) != 0 ? Default.INSTANCE : restCallState);
    }
}
