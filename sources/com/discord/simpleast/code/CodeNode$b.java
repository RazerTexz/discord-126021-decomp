package com.discord.simpleast.code;

import b.a.t.a.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import d0.z.d.m;

/* JADX INFO: compiled from: CodeNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeNode$b<RC> extends Node$a<RC> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode$b(String str, String str2, f<RC> fVar) {
        super(new StyleNode$b(str, fVar.d), new StyleNode$b(str2, fVar.f));
        m.checkNotNullParameter(str, "pre");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(fVar, "codeStyleProviders");
    }
}
