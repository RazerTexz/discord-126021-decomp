package com.discord.models.ktx;

import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelUserExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelUserExtensionsKt {
    public static final Person toPerson(User user) {
        m.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person$Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.getIsBot()).build();
        m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
