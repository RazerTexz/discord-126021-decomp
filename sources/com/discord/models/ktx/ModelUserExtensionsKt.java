package com.discord.models.ktx;

import androidx.core.app.Person;
import com.discord.models.user.User;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelUserExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelUserExtensionsKt {
    public static final Person toPerson(User user) {
        C12238m.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.isBot()).build();
        C12238m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
