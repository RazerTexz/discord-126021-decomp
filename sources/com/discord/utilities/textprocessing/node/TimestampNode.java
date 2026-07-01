package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.BackgroundColorSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.TimestampNode.RenderContext;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TimestampNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimestampNode<T extends RenderContext> extends Node<T> {
    private final CharSequence formatted;
    private final CharSequence full;

    /* JADX INFO: compiled from: TimestampNode.kt */
    public interface RenderContext extends BasicRenderContext {

        /* JADX INFO: compiled from: TimestampNode.kt */
        public static final class DefaultImpls {
            public static void onTimestampClicked(RenderContext renderContext, CharSequence charSequence) {
                Intrinsics3.checkNotNullParameter(charSequence, "full");
            }
        }

        void onTimestampClicked(CharSequence full);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    public TimestampNode(String str, String str2) {
        DateFormat dateTimeInstance;
        CharSequence relativeTimeSpanString;
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "timestampString");
        Date date = new Date(Long.parseLong(str) * ((long) 1000));
        String str3 = DateFormat.getDateTimeInstance(0, 3).format(date);
        Intrinsics3.checkNotNullExpressionValue(str3, "DateFormat.getDateTimeIn…ormat.SHORT).format(date)");
        this.full = str3;
        if (Intrinsics3.areEqual(str2, "R")) {
            relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(date.getTime());
            Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "DateUtils.getRelativeTimeSpanString(date.time)");
        } else {
            if (str2 != null) {
                int iHashCode = str2.hashCode();
                if (iHashCode != 68) {
                    if (iHashCode != 70) {
                        if (iHashCode != 84) {
                            if (iHashCode != 100) {
                                if (iHashCode != 102) {
                                    if (iHashCode == 116 && str2.equals("t")) {
                                        dateTimeInstance = DateFormat.getTimeInstance(3);
                                    } else {
                                        dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                                    }
                                } else if (str2.equals("f")) {
                                    dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                                } else {
                                    dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                                }
                            } else if (str2.equals("d")) {
                                dateTimeInstance = DateFormat.getDateInstance(3);
                            } else {
                                dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                            }
                        } else if (str2.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                            dateTimeInstance = DateFormat.getTimeInstance(2);
                        } else {
                            dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                        }
                    } else if (str2.equals("F")) {
                        dateTimeInstance = DateFormat.getDateTimeInstance(0, 3);
                    } else {
                        dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                    }
                } else if (str2.equals("D")) {
                    dateTimeInstance = DateFormat.getDateInstance(1);
                } else {
                    dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
                }
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
            }
            relativeTimeSpanString = dateTimeInstance.format(date);
            Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
        }
        this.formatted = relativeTimeSpanString;
    }

    public final CharSequence getFormatted() {
        return this.formatted;
    }

    public final CharSequence getFull() {
        return this.full;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        List listListOf = Collections2.listOf(new ClickableSpan(null, false, null, new TimestampNode2(this, renderContext), 4, null), new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.colorBackgroundModifierAccent)));
        int length = builder.length();
        builder.append(this.formatted);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
