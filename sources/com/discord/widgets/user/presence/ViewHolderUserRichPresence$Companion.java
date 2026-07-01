package com.discord.widgets.user.presence;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.c6;
import b.a.i.d6;
import b.a.i.g6;
import b.a.i.s5;
import b.a.i.t5;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.activity.Activity;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderUserRichPresence$Companion {
    private ViewHolderUserRichPresence$Companion() {
    }

    private final ViewHolderUserRichPresence createRPView(ViewGroup parent, int type) {
        String str;
        int i;
        int i2;
        ViewHolderUserRichPresence viewHolderPlatformRichPresence;
        String str2;
        int i3;
        String str3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (type == 1) {
            g6 g6VarA = g6.a(layoutInflaterFrom, parent, true);
            m.checkNotNullExpressionValue(g6VarA, "WidgetUserRichPresenceBi…e(inflater, parent, true)");
            SimpleDraweeView simpleDraweeView = g6VarA.e;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.richPresenceImageLarge");
            SimpleDraweeView simpleDraweeView2 = g6VarA.f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.richPresenceImageSmall");
            TextView textView = g6VarA.d;
            m.checkNotNullExpressionValue(textView, "binding.richPresenceHeader");
            TextView textView2 = g6VarA.k;
            m.checkNotNullExpressionValue(textView2, "binding.richPresenceTitle");
            TextView textView3 = g6VarA.c;
            m.checkNotNullExpressionValue(textView3, "binding.richPresenceDetails");
            TextView textView4 = g6VarA.j;
            m.checkNotNullExpressionValue(textView4, "binding.richPresenceTime");
            TextView textView5 = g6VarA.i;
            m.checkNotNullExpressionValue(textView5, "binding.richPresenceState");
            LinearLayout linearLayout = g6VarA.f122b;
            m.checkNotNullExpressionValue(linearLayout, "binding.richPresenceContainerData");
            MaterialButton materialButton = g6VarA.g;
            m.checkNotNullExpressionValue(materialButton, "binding.richPresencePrimaryButton");
            MaterialButton materialButton2 = g6VarA.h;
            m.checkNotNullExpressionValue(materialButton2, "binding.richPresenceSecondaryButton");
            return new ViewHolderGameRichPresence(parent, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, linearLayout, materialButton, materialButton2);
        }
        if (type == 2) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.widget_music_rich_presence, parent, false);
            parent.addView(viewInflate);
            Barrier barrier = (Barrier) viewInflate.findViewById(2131362146);
            if (barrier != null) {
                Space space = (Space) viewInflate.findViewById(R$id.image_bottom_guideline);
                if (space != null) {
                    LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R$id.rich_presence_container_data);
                    if (linearLayout2 != null) {
                        TextView textView6 = (TextView) viewInflate.findViewById(R$id.rich_presence_details);
                        if (textView6 != null) {
                            TextView textView7 = (TextView) viewInflate.findViewById(R$id.rich_presence_header);
                            if (textView7 != null) {
                                i = R$id.rich_presence_image_large;
                                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(R$id.rich_presence_image_large);
                                if (simpleDraweeView3 != null) {
                                    SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) viewInflate.findViewById(R$id.rich_presence_image_small);
                                    if (simpleDraweeView4 != null) {
                                        TextView textView8 = (TextView) viewInflate.findViewById(R$id.rich_presence_music_duration);
                                        str = "Missing required view with ID: ";
                                        if (textView8 != null) {
                                            TextView textView9 = (TextView) viewInflate.findViewById(R$id.rich_presence_music_elapsed);
                                            if (textView9 != null) {
                                                FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.rich_presence_music_progress_container);
                                                if (frameLayout != null) {
                                                    MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R$id.rich_presence_primary_button);
                                                    if (materialButton3 != null) {
                                                        SeekBar seekBar = (SeekBar) viewInflate.findViewById(R$id.rich_presence_seekbar);
                                                        if (seekBar != null) {
                                                            TextView textView10 = (TextView) viewInflate.findViewById(R$id.rich_presence_time);
                                                            if (textView10 != null) {
                                                                TextView textView11 = (TextView) viewInflate.findViewById(R$id.rich_presence_title);
                                                                if (textView11 != null) {
                                                                    m.checkNotNullExpressionValue(new s5((LinearLayout) viewInflate, barrier, space, linearLayout2, textView6, textView7, simpleDraweeView3, simpleDraweeView4, textView8, textView9, frameLayout, materialButton3, seekBar, textView10, textView11), "WidgetMusicRichPresenceB…e(inflater, parent, true)");
                                                                    m.checkNotNullExpressionValue(simpleDraweeView3, "binding.richPresenceImageLarge");
                                                                    m.checkNotNullExpressionValue(simpleDraweeView4, "binding.richPresenceImageSmall");
                                                                    m.checkNotNullExpressionValue(textView7, "binding.richPresenceHeader");
                                                                    m.checkNotNullExpressionValue(textView11, "binding.richPresenceTitle");
                                                                    m.checkNotNullExpressionValue(textView6, "binding.richPresenceDetails");
                                                                    m.checkNotNullExpressionValue(textView10, "binding.richPresenceTime");
                                                                    m.checkNotNullExpressionValue(linearLayout2, "binding.richPresenceContainerData");
                                                                    m.checkNotNullExpressionValue(materialButton3, "binding.richPresencePrimaryButton");
                                                                    m.checkNotNullExpressionValue(seekBar, "binding.richPresenceSeekbar");
                                                                    m.checkNotNullExpressionValue(textView8, "binding.richPresenceMusicDuration");
                                                                    m.checkNotNullExpressionValue(textView9, "binding.richPresenceMusicElapsed");
                                                                    return new ViewHolderMusicRichPresence(parent, simpleDraweeView3, simpleDraweeView4, textView7, textView11, textView6, textView10, linearLayout2, materialButton3, seekBar, textView8, textView9);
                                                                }
                                                                i = R$id.rich_presence_title;
                                                            } else {
                                                                i = R$id.rich_presence_time;
                                                            }
                                                        } else {
                                                            i = R$id.rich_presence_seekbar;
                                                        }
                                                    } else {
                                                        i = R$id.rich_presence_primary_button;
                                                    }
                                                } else {
                                                    i = R$id.rich_presence_music_progress_container;
                                                }
                                            } else {
                                                i = R$id.rich_presence_music_elapsed;
                                            }
                                        } else {
                                            i = R$id.rich_presence_music_duration;
                                        }
                                    } else {
                                        str = "Missing required view with ID: ";
                                        i = R$id.rich_presence_image_small;
                                    }
                                } else {
                                    str = "Missing required view with ID: ";
                                }
                            } else {
                                str = "Missing required view with ID: ";
                                i = R$id.rich_presence_header;
                            }
                        } else {
                            str = "Missing required view with ID: ";
                            i = R$id.rich_presence_details;
                        }
                    } else {
                        str = "Missing required view with ID: ";
                        i = R$id.rich_presence_container_data;
                    }
                } else {
                    str = "Missing required view with ID: ";
                    i = R$id.image_bottom_guideline;
                }
            } else {
                str = "Missing required view with ID: ";
                i = 2131362146;
            }
            throw new NullPointerException(str.concat(viewInflate.getResources().getResourceName(i)));
        }
        if (type == 3) {
            View viewInflate2 = layoutInflaterFrom.inflate(R$layout.widget_platform_rich_presence, parent, false);
            parent.addView(viewInflate2);
            Barrier barrier2 = (Barrier) viewInflate2.findViewById(2131362146);
            if (barrier2 != null) {
                Space space2 = (Space) viewInflate2.findViewById(R$id.image_bottom_guideline);
                if (space2 != null) {
                    LinearLayout linearLayout3 = (LinearLayout) viewInflate2.findViewById(R$id.rich_presence_container_data);
                    if (linearLayout3 != null) {
                        TextView textView12 = (TextView) viewInflate2.findViewById(R$id.rich_presence_header);
                        if (textView12 != null) {
                            SimpleDraweeView simpleDraweeView5 = (SimpleDraweeView) viewInflate2.findViewById(R$id.rich_presence_image_large);
                            if (simpleDraweeView5 != null) {
                                SimpleDraweeView simpleDraweeView6 = (SimpleDraweeView) viewInflate2.findViewById(R$id.rich_presence_image_small);
                                if (simpleDraweeView6 != null) {
                                    MaterialButton materialButton4 = (MaterialButton) viewInflate2.findViewById(R$id.rich_presence_primary_button);
                                    if (materialButton4 != null) {
                                        TextView textView13 = (TextView) viewInflate2.findViewById(R$id.rich_presence_time);
                                        if (textView13 != null) {
                                            TextView textView14 = (TextView) viewInflate2.findViewById(R$id.rich_presence_title);
                                            if (textView14 != null) {
                                                m.checkNotNullExpressionValue(new t5((LinearLayout) viewInflate2, barrier2, space2, linearLayout3, textView12, simpleDraweeView5, simpleDraweeView6, materialButton4, textView13, textView14), "WidgetPlatformRichPresen…e(inflater, parent, true)");
                                                m.checkNotNullExpressionValue(simpleDraweeView5, "binding.richPresenceImageLarge");
                                                m.checkNotNullExpressionValue(simpleDraweeView6, "binding.richPresenceImageSmall");
                                                m.checkNotNullExpressionValue(textView12, "binding.richPresenceHeader");
                                                m.checkNotNullExpressionValue(textView14, "binding.richPresenceTitle");
                                                m.checkNotNullExpressionValue(textView13, "binding.richPresenceTime");
                                                m.checkNotNullExpressionValue(linearLayout3, "binding.richPresenceContainerData");
                                                m.checkNotNullExpressionValue(materialButton4, "binding.richPresencePrimaryButton");
                                                viewHolderPlatformRichPresence = new ViewHolderPlatformRichPresence(parent, simpleDraweeView5, simpleDraweeView6, textView12, textView14, textView13, linearLayout3, materialButton4);
                                            } else {
                                                i2 = R$id.rich_presence_title;
                                            }
                                        } else {
                                            i2 = R$id.rich_presence_time;
                                        }
                                    } else {
                                        i2 = R$id.rich_presence_primary_button;
                                    }
                                } else {
                                    i2 = R$id.rich_presence_image_small;
                                }
                            } else {
                                i2 = R$id.rich_presence_image_large;
                            }
                        } else {
                            i2 = R$id.rich_presence_header;
                        }
                    } else {
                        i2 = R$id.rich_presence_container_data;
                    }
                } else {
                    i2 = R$id.image_bottom_guideline;
                }
            } else {
                i2 = 2131362146;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        }
        if (type == 4) {
            View viewInflate3 = layoutInflaterFrom.inflate(R$layout.widget_stream_rich_presence, parent, false);
            parent.addView(viewInflate3);
            LinearLayout linearLayout4 = (LinearLayout) viewInflate3.findViewById(R$id.rich_presence_container_data);
            if (linearLayout4 != null) {
                TextView textView15 = (TextView) viewInflate3.findViewById(R$id.rich_presence_details);
                if (textView15 != null) {
                    TextView textView16 = (TextView) viewInflate3.findViewById(R$id.rich_presence_header);
                    if (textView16 != null) {
                        SimpleDraweeView simpleDraweeView7 = (SimpleDraweeView) viewInflate3.findViewById(R$id.rich_presence_image_large);
                        if (simpleDraweeView7 != null) {
                            TextView textView17 = (TextView) viewInflate3.findViewById(R$id.rich_presence_state);
                            if (textView17 != null) {
                                TextView textView18 = (TextView) viewInflate3.findViewById(R$id.rich_presence_time);
                                if (textView18 != null) {
                                    TextView textView19 = (TextView) viewInflate3.findViewById(R$id.rich_presence_title);
                                    str2 = "Missing required view with ID: ";
                                    if (textView19 != null) {
                                        StreamPreviewView streamPreviewView = (StreamPreviewView) viewInflate3.findViewById(R$id.stream_preview);
                                        if (streamPreviewView != null) {
                                            m.checkNotNullExpressionValue(new d6((ConstraintLayout) viewInflate3, linearLayout4, textView15, textView16, simpleDraweeView7, textView17, textView18, textView19, streamPreviewView), "WidgetStreamRichPresence…e(inflater, parent, true)");
                                            m.checkNotNullExpressionValue(simpleDraweeView7, "binding.richPresenceImageLarge");
                                            m.checkNotNullExpressionValue(textView16, "binding.richPresenceHeader");
                                            m.checkNotNullExpressionValue(textView19, "binding.richPresenceTitle");
                                            m.checkNotNullExpressionValue(textView15, "binding.richPresenceDetails");
                                            m.checkNotNullExpressionValue(textView18, "binding.richPresenceTime");
                                            m.checkNotNullExpressionValue(textView17, "binding.richPresenceState");
                                            m.checkNotNullExpressionValue(linearLayout4, "binding.richPresenceContainerData");
                                            m.checkNotNullExpressionValue(streamPreviewView, "binding.streamPreview");
                                            viewHolderPlatformRichPresence = new ViewHolderStreamRichPresence(parent, simpleDraweeView7, textView16, textView19, textView15, textView18, textView17, linearLayout4, streamPreviewView);
                                        } else {
                                            i3 = R$id.stream_preview;
                                        }
                                    } else {
                                        i3 = R$id.rich_presence_title;
                                    }
                                } else {
                                    str2 = "Missing required view with ID: ";
                                    i3 = R$id.rich_presence_time;
                                }
                            } else {
                                str2 = "Missing required view with ID: ";
                                i3 = R$id.rich_presence_state;
                            }
                        } else {
                            str2 = "Missing required view with ID: ";
                            i3 = R$id.rich_presence_image_large;
                        }
                    } else {
                        str2 = "Missing required view with ID: ";
                        i3 = R$id.rich_presence_header;
                    }
                } else {
                    str2 = "Missing required view with ID: ";
                    i3 = R$id.rich_presence_details;
                }
            } else {
                str2 = "Missing required view with ID: ";
                i3 = R$id.rich_presence_container_data;
            }
            throw new NullPointerException(str2.concat(viewInflate3.getResources().getResourceName(i3)));
        }
        if (type != 5) {
            g6 g6VarA2 = g6.a(layoutInflaterFrom, parent, true);
            m.checkNotNullExpressionValue(g6VarA2, "WidgetUserRichPresenceBi…e(inflater, parent, true)");
            SimpleDraweeView simpleDraweeView8 = g6VarA2.e;
            m.checkNotNullExpressionValue(simpleDraweeView8, "binding.richPresenceImageLarge");
            SimpleDraweeView simpleDraweeView9 = g6VarA2.f;
            TextView textView20 = g6VarA2.d;
            m.checkNotNullExpressionValue(textView20, "binding.richPresenceHeader");
            TextView textView21 = g6VarA2.k;
            m.checkNotNullExpressionValue(textView21, "binding.richPresenceTitle");
            TextView textView22 = g6VarA2.c;
            TextView textView23 = g6VarA2.j;
            m.checkNotNullExpressionValue(textView23, "binding.richPresenceTime");
            TextView textView24 = g6VarA2.i;
            LinearLayout linearLayout5 = g6VarA2.f122b;
            m.checkNotNullExpressionValue(linearLayout5, "binding.richPresenceContainerData");
            return new ViewHolderUserRichPresence(parent, simpleDraweeView8, simpleDraweeView9, textView20, textView21, textView22, textView23, textView24, linearLayout5, g6VarA2.g, g6VarA2.h, 0, 2048, null);
        }
        View viewInflate4 = layoutInflaterFrom.inflate(R$layout.widget_stage_channel_rich_presence, parent, false);
        parent.addView(viewInflate4);
        Barrier barrier3 = (Barrier) viewInflate4.findViewById(2131362146);
        if (barrier3 != null) {
            Space space3 = (Space) viewInflate4.findViewById(R$id.image_bottom_guideline);
            if (space3 != null) {
                LinearLayout linearLayout6 = (LinearLayout) viewInflate4.findViewById(R$id.rich_presence_container_data);
                if (linearLayout6 != null) {
                    TextView textView25 = (TextView) viewInflate4.findViewById(R$id.rich_presence_details);
                    if (textView25 != null) {
                        TextView textView26 = (TextView) viewInflate4.findViewById(R$id.rich_presence_header);
                        if (textView26 != null) {
                            SimpleDraweeView simpleDraweeView10 = (SimpleDraweeView) viewInflate4.findViewById(R$id.rich_presence_image_large);
                            if (simpleDraweeView10 != null) {
                                TextView textView27 = (TextView) viewInflate4.findViewById(R$id.rich_presence_image_large_text);
                                if (textView27 != null) {
                                    FrameLayout frameLayout2 = (FrameLayout) viewInflate4.findViewById(R$id.rich_presence_image_large_wrap);
                                    if (frameLayout2 != null) {
                                        MaterialButton materialButton5 = (MaterialButton) viewInflate4.findViewById(R$id.rich_presence_primary_button);
                                        if (materialButton5 != null) {
                                            TextView textView28 = (TextView) viewInflate4.findViewById(R$id.rich_presence_time);
                                            str3 = "Missing required view with ID: ";
                                            if (textView28 != null) {
                                                TextView textView29 = (TextView) viewInflate4.findViewById(R$id.rich_presence_title);
                                                if (textView29 != null) {
                                                    m.checkNotNullExpressionValue(new c6((LinearLayout) viewInflate4, barrier3, space3, linearLayout6, textView25, textView26, simpleDraweeView10, textView27, frameLayout2, materialButton5, textView28, textView29), "WidgetStageChannelRichPr…e(inflater, parent, true)");
                                                    m.checkNotNullExpressionValue(simpleDraweeView10, "binding.richPresenceImageLarge");
                                                    m.checkNotNullExpressionValue(textView26, "binding.richPresenceHeader");
                                                    m.checkNotNullExpressionValue(textView29, "binding.richPresenceTitle");
                                                    m.checkNotNullExpressionValue(textView25, "binding.richPresenceDetails");
                                                    m.checkNotNullExpressionValue(textView28, "binding.richPresenceTime");
                                                    m.checkNotNullExpressionValue(linearLayout6, "binding.richPresenceContainerData");
                                                    m.checkNotNullExpressionValue(materialButton5, "binding.richPresencePrimaryButton");
                                                    m.checkNotNullExpressionValue(textView27, "binding.richPresenceImageLargeText");
                                                    viewHolderPlatformRichPresence = new ViewHolderStageChannelRichPresence(parent, simpleDraweeView10, textView26, textView29, textView25, textView28, linearLayout6, materialButton5, textView27);
                                                } else {
                                                    i4 = R$id.rich_presence_title;
                                                }
                                            } else {
                                                i4 = R$id.rich_presence_time;
                                            }
                                        } else {
                                            str3 = "Missing required view with ID: ";
                                            i4 = R$id.rich_presence_primary_button;
                                        }
                                    } else {
                                        str3 = "Missing required view with ID: ";
                                        i4 = R$id.rich_presence_image_large_wrap;
                                    }
                                } else {
                                    str3 = "Missing required view with ID: ";
                                    i4 = R$id.rich_presence_image_large_text;
                                }
                            } else {
                                str3 = "Missing required view with ID: ";
                                i4 = R$id.rich_presence_image_large;
                            }
                        } else {
                            str3 = "Missing required view with ID: ";
                            i4 = R$id.rich_presence_header;
                        }
                    } else {
                        str3 = "Missing required view with ID: ";
                        i4 = R$id.rich_presence_details;
                    }
                } else {
                    str3 = "Missing required view with ID: ";
                    i4 = R$id.rich_presence_container_data;
                }
            } else {
                str3 = "Missing required view with ID: ";
                i4 = R$id.image_bottom_guideline;
            }
        } else {
            str3 = "Missing required view with ID: ";
            i4 = 2131362146;
        }
        throw new NullPointerException(str3.concat(viewInflate4.getResources().getResourceName(i4)));
        return viewHolderPlatformRichPresence;
    }

    private final int getRPViewHolderType(Activity activity, StreamContext streamContext) {
        if (streamContext != null) {
            return 4;
        }
        if (activity != null && ActivityUtilsKt.isGamePlatform(activity)) {
            return 3;
        }
        if (activity != null && ActivityUtilsKt.isGameActivity(activity)) {
            return 1;
        }
        if (activity == null || !ActivityUtilsKt.isSpotifyActivity(activity)) {
            return (activity == null || !ActivityUtilsKt.isStageChannelActivity(activity)) ? 0 : 5;
        }
        return 2;
    }

    public final ViewHolderUserRichPresence setRichPresence(ViewGroup parent, Activity activity, StreamContext streamContext, ViewHolderUserRichPresence oldViewHolder) {
        m.checkNotNullParameter(parent, "parent");
        int rPViewHolderType = getRPViewHolderType(activity, streamContext);
        if (oldViewHolder != null && rPViewHolderType == oldViewHolder.getRichPresenceType()) {
            return oldViewHolder;
        }
        parent.removeAllViews();
        return ViewHolderUserRichPresence.Companion.createRPView(parent, rPViewHolderType);
    }

    public /* synthetic */ ViewHolderUserRichPresence$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
