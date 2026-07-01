package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.BlockBackgroundNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createCodeBlockRule$1<RC, S> extends o implements Function3<CodeNode<RC>, Boolean, S, Node<RC>> {
    public static final Rules$createCodeBlockRule$1 INSTANCE = new Rules$createCodeBlockRule$1();

    public Rules$createCodeBlockRule$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
        return invoke((CodeNode) obj, bool.booleanValue(), (Rules$BlockQuoteState) obj2);
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/discord/simpleast/code/CodeNode<TRC;>;ZTS;)Lcom/discord/simpleast/core/node/Node<TRC;>; */
    public final Node invoke(CodeNode codeNode, boolean z2, Rules$BlockQuoteState rules$BlockQuoteState) {
        m.checkNotNullParameter(codeNode, "codeNode");
        m.checkNotNullParameter(rules$BlockQuoteState, "state");
        return !z2 ? new Rules$createCodeBlockRule$1$1(codeNode, new Node[]{codeNode}) : new BlockBackgroundNode(rules$BlockQuoteState.getIsInQuote(), codeNode);
    }
}
