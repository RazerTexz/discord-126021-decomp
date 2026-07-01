package com.discord.simpleast.code;

import com.discord.simpleast.core.node.Node;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: CodeNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeNode$a$a<RC> extends CodeNode$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Node<RC>> f2807b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CodeNode$a$a(String str, List<? extends Node<RC>> list) {
        super(str, null);
        m.checkNotNullParameter(str, "raw");
        m.checkNotNullParameter(list, "children");
        this.f2807b = list;
    }
}
