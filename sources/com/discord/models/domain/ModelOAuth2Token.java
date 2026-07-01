package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelOAuth2Token.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelOAuth2Token {
    private final Application application;
    private final long id;
    private final List<OAuthScope> scopes;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelOAuth2Token(long j, List<? extends OAuthScope> list, Application application) {
        m.checkNotNullParameter(list, "scopes");
        m.checkNotNullParameter(application, "application");
        this.id = j;
        this.scopes = list;
        this.application = application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelOAuth2Token copy$default(ModelOAuth2Token modelOAuth2Token, long j, List list, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelOAuth2Token.id;
        }
        if ((i & 2) != 0) {
            list = modelOAuth2Token.scopes;
        }
        if ((i & 4) != 0) {
            application = modelOAuth2Token.application;
        }
        return modelOAuth2Token.copy(j, list, application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<OAuthScope> component2() {
        return this.scopes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ModelOAuth2Token copy(long id2, List<? extends OAuthScope> scopes, Application application) {
        m.checkNotNullParameter(scopes, "scopes");
        m.checkNotNullParameter(application, "application");
        return new ModelOAuth2Token(id2, scopes, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelOAuth2Token)) {
            return false;
        }
        ModelOAuth2Token modelOAuth2Token = (ModelOAuth2Token) other;
        return this.id == modelOAuth2Token.id && m.areEqual(this.scopes, modelOAuth2Token.scopes) && m.areEqual(this.application, modelOAuth2Token.application);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getId() {
        return this.id;
    }

    public final List<OAuthScope> getScopes() {
        return this.scopes;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<OAuthScope> list = this.scopes;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Application application = this.application;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelOAuth2Token(id=");
        sbU.append(this.id);
        sbU.append(", scopes=");
        sbU.append(this.scopes);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
