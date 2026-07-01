package com.discord.utilities.auth;

import android.net.Uri;
import b.c.a.a0.d;
import b.i.a.f.c.a.a;
import b.i.a.f.c.a.d.c;
import b.i.a.f.e.k.k;
import b.i.a.f.h.c.h;
import b.i.a.f.h.c.i;
import com.discord.models.user.MeUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credential$a;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager$saveCredentials$1 extends o implements Function1<MeUser, Unit> {
    public final /* synthetic */ String $id;
    public final /* synthetic */ String $password;
    public final /* synthetic */ GoogleSmartLockManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleSmartLockManager$saveCredentials$1(GoogleSmartLockManager googleSmartLockManager, String str, String str2) {
        super(1);
        this.this$0 = googleSmartLockManager;
        this.$id = str;
        this.$password = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
        invoke2(meUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MeUser meUser) {
        String forUser$default = IconUtils.getForUser$default(meUser, false, null, 4, null);
        Credential$a credential$a = new Credential$a(this.$id);
        credential$a.d = this.$password;
        m.checkNotNullExpressionValue(credential$a, "Credential.Builder(id)\n …   .setPassword(password)");
        UserUtils userUtils = UserUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "it");
        credential$a.f2995b = UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null).toString();
        credential$a.c = Uri.parse(forUser$default);
        Credential credentialA = credential$a.a();
        CredentialsClient credentialsClientAccess$getCredentialsClient$p = GoogleSmartLockManager.access$getCredentialsClient$p(this.this$0);
        Objects.requireNonNull(credentialsClientAccess$getCredentialsClient$p);
        c cVar = a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClientAccess$getCredentialsClient$p.g;
        Objects.requireNonNull((h) cVar);
        d.z(cVar2, "client must not be null");
        d.z(credentialA, "credential must not be null");
        k.a(cVar2.b(new i(cVar2, credentialA))).b(new GoogleSmartLockManager$saveCredentials$1$1(this));
    }
}
