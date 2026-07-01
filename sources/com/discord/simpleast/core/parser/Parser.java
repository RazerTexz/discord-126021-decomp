package com.discord.simpleast.core.parser;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.simpleast.core.node.Node;
import d0.Tuples;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: classes.dex */
public class Parser<R, T extends Node<R>, S> {
    private static final String TAG = "Parser";
    private final boolean enableDebugging;
    private final ArrayList<Rule<R, ? extends T, S>> rules;

    /* JADX INFO: compiled from: Parser.kt */
    public static final class ParseException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParseException(String str, CharSequence charSequence, Throwable th) {
            super("Error while parsing: " + str + " \n Source: " + charSequence, th);
            Intrinsics3.checkNotNullParameter(str, "message");
        }
    }

    public Parser() {
        this(false, 1, null);
    }

    public Parser(boolean z2) {
        this.enableDebugging = z2;
        this.rules = new ArrayList<>();
    }

    private final <R, T extends Node<R>, S> void logMatch(Rule<R, T, S> rule, CharSequence source) {
        if (this.enableDebugging) {
            StringBuilder sbU = outline.U("MATCH: with rule with pattern: ");
            sbU.append(rule.getMatcher().pattern().toString());
            sbU.append(" to source: ");
            sbU.append(source);
            Log.i(TAG, sbU.toString());
        }
    }

    private final <R, T extends Node<R>, S> void logMiss(Rule<R, T, S> rule, CharSequence source) {
        if (this.enableDebugging) {
            StringBuilder sbU = outline.U("MISS: with rule with pattern: ");
            sbU.append(rule.getMatcher().pattern().toString());
            sbU.append(" to source: ");
            sbU.append(source);
            Log.i(TAG, sbU.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List parse$default(Parser parser, CharSequence charSequence, Object obj, List list, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parse");
        }
        if ((i & 4) != 0) {
            list = parser.rules;
        }
        return parser.parse(charSequence, obj, list);
    }

    public final Parser<R, T, S> addRule(Rule<R, ? extends T, S> rule) {
        Intrinsics3.checkNotNullParameter(rule, "rule");
        this.rules.add(rule);
        return this;
    }

    public final Parser<R, T, S> addRules(Rule<R, ? extends T, S>... newRules) {
        Intrinsics3.checkNotNullParameter(newRules, "newRules");
        return addRules(_ArraysJvm.asList(newRules));
    }

    public final List<T> parse(CharSequence charSequence, S s2) {
        return parse$default(this, charSequence, s2, null, 4, null);
    }

    public final List<T> parse(CharSequence source, S initialState, List<? extends Rule<R, ? extends T, S>> rules) {
        ParseSpec parseSpec;
        int i;
        int i2;
        Tuples2 tuples2;
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(rules, "rules");
        Stack stack = new Stack();
        Node node = new Node(null, 1, null);
        if (source.length() > 0) {
            stack.add(new ParseSpec(node, initialState, 0, source.length()));
        }
        String strGroup = null;
        while (!stack.isEmpty() && (i = (parseSpec = (ParseSpec) stack.pop()).startIndex) < (i2 = parseSpec.endIndex)) {
            CharSequence charSequenceSubSequence = source.subSequence(i, i2);
            int i3 = parseSpec.startIndex;
            Iterator<? extends Rule<R, ? extends T, S>> it = rules.iterator();
            do {
                if (!it.hasNext()) {
                    tuples2 = null;
                    break;
                }
                Rule<R, ? extends T, S> next = it.next();
                Matcher matcherMatch = next.match(charSequenceSubSequence, strGroup, parseSpec.state);
                if (matcherMatch == null) {
                    logMiss(next, charSequenceSubSequence);
                    tuples2 = null;
                } else {
                    logMatch(next, charSequenceSubSequence);
                    tuples2 = Tuples.to(next, matcherMatch);
                }
            } while (tuples2 == null);
            if (tuples2 == null) {
                throw new ParseException("failed to find rule to match source", source, null);
            }
            Rule rule = (Rule) tuples2.component1();
            Matcher matcher = (Matcher) tuples2.component2();
            int iEnd = matcher.end() + i3;
            ParseSpec<R, S> parseSpec2 = rule.parse(matcher, this, parseSpec.state);
            Node<R> node2 = parseSpec.root;
            node2.addChild(parseSpec2.root);
            int i4 = parseSpec.endIndex;
            if (iEnd != i4) {
                S s2 = parseSpec.state;
                Intrinsics3.checkNotNullParameter(node2, "node");
                stack.push(new ParseSpec(node2, s2, iEnd, i4));
            }
            if (!parseSpec2.isTerminal) {
                parseSpec2.startIndex += i3;
                parseSpec2.endIndex += i3;
                stack.push(parseSpec2);
            }
            try {
                strGroup = matcher.group(0);
            } catch (Throwable th) {
                throw new ParseException("matcher found no matches", source, th);
            }
        }
        Collection<Node<R>> children = node.getChildren();
        List<T> mutableList = children != null ? _Collections.toMutableList((Collection) children) : null;
        List<T> list = TypeIntrinsics.isMutableList(mutableList) ? mutableList : null;
        return list != null ? list : new ArrayList();
    }

    public final Parser<R, T, S> addRules(Collection<? extends Rule<R, ? extends T, S>> newRules) {
        Intrinsics3.checkNotNullParameter(newRules, "newRules");
        this.rules.addAll(newRules);
        return this;
    }

    public /* synthetic */ Parser(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }
}
