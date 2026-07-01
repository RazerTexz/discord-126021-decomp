package com.discord.models.ktx;

import androidx.core.app.Person;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.ktx.ModelUserExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: ModelUserExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelUserExtensions {
    public static final Person toPerson(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.isBot()).build();
        Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
