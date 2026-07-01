package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.node.Node;
import d0.z.d.m;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TagsBuilder$Companion {
    private TagsBuilder$Companion() {
    }

    public final Tags extractTags(Collection<? extends Node<?>> ast) {
        m.checkNotNullParameter(ast, "ast");
        TagsBuilder tagsBuilder = new TagsBuilder();
        tagsBuilder.processAst(ast);
        return tagsBuilder.build();
    }

    public /* synthetic */ TagsBuilder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
