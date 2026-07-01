package com.discord.widgets.guilds.join;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteArgs extends CaptchaArgs {
    private final ModelInvite invite;
    private final Class<?> javaClass;
    private final String location;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInviteFlowFinished;
    private final Function2<Error, Continuation<? super Unit>, Object> onInvitePostError;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInvitePostSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InviteArgs(ModelInvite modelInvite, Class<?> cls, String str, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function4) {
        super(null);
        m.checkNotNullParameter(modelInvite, "invite");
        m.checkNotNullParameter(cls, "javaClass");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(function2, "onInvitePostError");
        m.checkNotNullParameter(function3, "onInvitePostSuccess");
        m.checkNotNullParameter(function4, "onInviteFlowFinished");
        this.invite = modelInvite;
        this.javaClass = cls;
        this.location = str;
        this.onInvitePostError = function2;
        this.onInvitePostSuccess = function3;
        this.onInviteFlowFinished = function4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteArgs copy$default(InviteArgs inviteArgs, ModelInvite modelInvite, Class cls, String str, Function2 function2, Function2 function3, Function2 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = inviteArgs.invite;
        }
        if ((i & 2) != 0) {
            cls = inviteArgs.javaClass;
        }
        Class cls2 = cls;
        if ((i & 4) != 0) {
            str = inviteArgs.location;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            function2 = inviteArgs.onInvitePostError;
        }
        Function2 function5 = function2;
        if ((i & 16) != 0) {
            function3 = inviteArgs.onInvitePostSuccess;
        }
        Function2 function6 = function3;
        if ((i & 32) != 0) {
            function4 = inviteArgs.onInviteFlowFinished;
        }
        return inviteArgs.copy(modelInvite, cls2, str2, function5, function6, function4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> component2() {
        return this.javaClass;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> component4() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component5() {
        return this.onInvitePostSuccess;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component6() {
        return this.onInviteFlowFinished;
    }

    public final InviteArgs copy(ModelInvite invite, Class<?> javaClass, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(javaClass, "javaClass");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        m.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        m.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        return new InviteArgs(invite, javaClass, location, onInvitePostError, onInvitePostSuccess, onInviteFlowFinished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteArgs)) {
            return false;
        }
        InviteArgs inviteArgs = (InviteArgs) other;
        return m.areEqual(this.invite, inviteArgs.invite) && m.areEqual(this.javaClass, inviteArgs.javaClass) && m.areEqual(this.location, inviteArgs.location) && m.areEqual(this.onInvitePostError, inviteArgs.onInvitePostError) && m.areEqual(this.onInvitePostSuccess, inviteArgs.onInvitePostSuccess) && m.areEqual(this.onInviteFlowFinished, inviteArgs.onInviteFlowFinished);
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> getJavaClass() {
        return this.javaClass;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInviteFlowFinished() {
        return this.onInviteFlowFinished;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> getOnInvitePostError() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInvitePostSuccess() {
        return this.onInvitePostSuccess;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        Class<?> cls = this.javaClass;
        int iHashCode2 = (iHashCode + (cls != null ? cls.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Function2<Error, Continuation<? super Unit>, Object> function2 = this.onInvitePostError;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function3 = this.onInvitePostSuccess;
        int iHashCode5 = (iHashCode4 + (function3 != null ? function3.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function4 = this.onInviteFlowFinished;
        return iHashCode5 + (function4 != null ? function4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteArgs(invite=");
        sbU.append(this.invite);
        sbU.append(", javaClass=");
        sbU.append(this.javaClass);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", onInvitePostError=");
        sbU.append(this.onInvitePostError);
        sbU.append(", onInvitePostSuccess=");
        sbU.append(this.onInvitePostSuccess);
        sbU.append(", onInviteFlowFinished=");
        sbU.append(this.onInviteFlowFinished);
        sbU.append(")");
        return sbU.toString();
    }
}
