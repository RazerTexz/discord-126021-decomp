package com.discord.utilities.textprocessing;

import b.a.t.b.c.a;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.EmojiNode;

/* JADX INFO: compiled from: MessagePreprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessagePreprocessor$process$1 implements a {
    public static final MessagePreprocessor$process$1 INSTANCE = new MessagePreprocessor$process$1();

    @Override // b.a.t.b.c.a
    public final void processNode(Node<Object> node) {
        if (node instanceof EmojiNode) {
            ((EmojiNode) node).setJumbo(true);
        }
    }
}
