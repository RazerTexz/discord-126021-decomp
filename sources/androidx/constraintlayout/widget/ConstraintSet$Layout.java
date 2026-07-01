package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionScene;
import b.d.b.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet$Layout {
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int DIMENSION_RATIO = 5;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_PERCENT = 70;
    private static final int HORIZONTAL_BIAS = 20;
    private static final int HORIZONTAL_STYLE = 39;
    private static final int HORIZONTAL_WEIGHT = 37;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_WIDTH = 22;
    private static final int LEFT_MARGIN = 23;
    private static final int LEFT_TO_LEFT = 24;
    private static final int LEFT_TO_RIGHT = 25;
    private static final int ORIENTATION = 26;
    private static final int RIGHT_MARGIN = 27;
    private static final int RIGHT_TO_LEFT = 28;
    private static final int RIGHT_TO_RIGHT = 29;
    private static final int START_MARGIN = 30;
    private static final int START_TO_END = 31;
    private static final int START_TO_START = 32;
    private static final int TOP_MARGIN = 33;
    private static final int TOP_TO_BOTTOM = 34;
    private static final int TOP_TO_TOP = 35;
    public static final int UNSET = -1;
    private static final int UNUSED = 76;
    private static final int VERTICAL_BIAS = 36;
    private static final int VERTICAL_STYLE = 40;
    private static final int VERTICAL_WEIGHT = 38;
    private static final int WIDTH_PERCENT = 69;
    private static SparseIntArray mapToConstant;
    public String mConstraintTag;
    public int mHeight;
    public String mReferenceIdString;
    public int[] mReferenceIds;
    public int mWidth;
    public boolean mIsGuideline = false;
    public boolean mApply = false;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0f;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int topToTop = -1;
    public int topToBottom = -1;
    public int bottomToTop = -1;
    public int bottomToBottom = -1;
    public int baselineToBaseline = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int endToStart = -1;
    public int endToEnd = -1;
    public float horizontalBias = 0.5f;
    public float verticalBias = 0.5f;
    public String dimensionRatio = null;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public float circleAngle = 0.0f;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int orientation = -1;
    public int leftMargin = -1;
    public int rightMargin = -1;
    public int topMargin = -1;
    public int bottomMargin = -1;
    public int endMargin = -1;
    public int startMargin = -1;
    public int goneLeftMargin = -1;
    public int goneTopMargin = -1;
    public int goneRightMargin = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneStartMargin = -1;
    public float verticalWeight = -1.0f;
    public float horizontalWeight = -1.0f;
    public int horizontalChainStyle = 0;
    public int verticalChainStyle = 0;
    public int widthDefault = 0;
    public int heightDefault = 0;
    public int widthMax = -1;
    public int heightMax = -1;
    public int widthMin = -1;
    public int heightMin = -1;
    public float widthPercent = 1.0f;
    public float heightPercent = 1.0f;
    public int mBarrierDirection = -1;
    public int mBarrierMargin = 0;
    public int mHelperType = -1;
    public boolean constrainedWidth = false;
    public boolean constrainedHeight = false;
    public boolean mBarrierAllowsGoneWidgets = true;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
        mapToConstant.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
        mapToConstant.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
        mapToConstant.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
        mapToConstant.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
        mapToConstant.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
        mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R$styleable.Layout_layout_editor_absoluteX, 6);
        mapToConstant.append(R$styleable.Layout_layout_editor_absoluteY, 7);
        mapToConstant.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
        mapToConstant.append(R$styleable.Layout_layout_constraintGuide_end, 18);
        mapToConstant.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
        mapToConstant.append(R$styleable.Layout_android_orientation, 26);
        mapToConstant.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
        mapToConstant.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
        mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginLeft, 13);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginTop, 16);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginRight, 14);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginBottom, 11);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginStart, 15);
        mapToConstant.append(R$styleable.Layout_layout_goneMarginEnd, 12);
        mapToConstant.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
        mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
        mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
        mapToConstant.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
        mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
        mapToConstant.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
        mapToConstant.append(R$styleable.Layout_layout_constraintTop_creator, 76);
        mapToConstant.append(R$styleable.Layout_layout_constraintRight_creator, 76);
        mapToConstant.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
        mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
        mapToConstant.append(R$styleable.Layout_android_layout_marginLeft, 23);
        mapToConstant.append(R$styleable.Layout_android_layout_marginRight, 27);
        mapToConstant.append(R$styleable.Layout_android_layout_marginStart, 30);
        mapToConstant.append(R$styleable.Layout_android_layout_marginEnd, 8);
        mapToConstant.append(R$styleable.Layout_android_layout_marginTop, 33);
        mapToConstant.append(R$styleable.Layout_android_layout_marginBottom, 2);
        mapToConstant.append(R$styleable.Layout_android_layout_width, 22);
        mapToConstant.append(R$styleable.Layout_android_layout_height, 21);
        mapToConstant.append(R$styleable.Layout_layout_constraintCircle, 61);
        mapToConstant.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
        mapToConstant.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
        mapToConstant.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
        mapToConstant.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
        mapToConstant.append(R$styleable.Layout_chainUseRtl, 71);
        mapToConstant.append(R$styleable.Layout_barrierDirection, 72);
        mapToConstant.append(R$styleable.Layout_barrierMargin, 73);
        mapToConstant.append(R$styleable.Layout_constraint_referenced_ids, 74);
        mapToConstant.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
    }

    public void copyFrom(ConstraintSet$Layout constraintSet$Layout) {
        this.mIsGuideline = constraintSet$Layout.mIsGuideline;
        this.mWidth = constraintSet$Layout.mWidth;
        this.mApply = constraintSet$Layout.mApply;
        this.mHeight = constraintSet$Layout.mHeight;
        this.guideBegin = constraintSet$Layout.guideBegin;
        this.guideEnd = constraintSet$Layout.guideEnd;
        this.guidePercent = constraintSet$Layout.guidePercent;
        this.leftToLeft = constraintSet$Layout.leftToLeft;
        this.leftToRight = constraintSet$Layout.leftToRight;
        this.rightToLeft = constraintSet$Layout.rightToLeft;
        this.rightToRight = constraintSet$Layout.rightToRight;
        this.topToTop = constraintSet$Layout.topToTop;
        this.topToBottom = constraintSet$Layout.topToBottom;
        this.bottomToTop = constraintSet$Layout.bottomToTop;
        this.bottomToBottom = constraintSet$Layout.bottomToBottom;
        this.baselineToBaseline = constraintSet$Layout.baselineToBaseline;
        this.startToEnd = constraintSet$Layout.startToEnd;
        this.startToStart = constraintSet$Layout.startToStart;
        this.endToStart = constraintSet$Layout.endToStart;
        this.endToEnd = constraintSet$Layout.endToEnd;
        this.horizontalBias = constraintSet$Layout.horizontalBias;
        this.verticalBias = constraintSet$Layout.verticalBias;
        this.dimensionRatio = constraintSet$Layout.dimensionRatio;
        this.circleConstraint = constraintSet$Layout.circleConstraint;
        this.circleRadius = constraintSet$Layout.circleRadius;
        this.circleAngle = constraintSet$Layout.circleAngle;
        this.editorAbsoluteX = constraintSet$Layout.editorAbsoluteX;
        this.editorAbsoluteY = constraintSet$Layout.editorAbsoluteY;
        this.orientation = constraintSet$Layout.orientation;
        this.leftMargin = constraintSet$Layout.leftMargin;
        this.rightMargin = constraintSet$Layout.rightMargin;
        this.topMargin = constraintSet$Layout.topMargin;
        this.bottomMargin = constraintSet$Layout.bottomMargin;
        this.endMargin = constraintSet$Layout.endMargin;
        this.startMargin = constraintSet$Layout.startMargin;
        this.goneLeftMargin = constraintSet$Layout.goneLeftMargin;
        this.goneTopMargin = constraintSet$Layout.goneTopMargin;
        this.goneRightMargin = constraintSet$Layout.goneRightMargin;
        this.goneBottomMargin = constraintSet$Layout.goneBottomMargin;
        this.goneEndMargin = constraintSet$Layout.goneEndMargin;
        this.goneStartMargin = constraintSet$Layout.goneStartMargin;
        this.verticalWeight = constraintSet$Layout.verticalWeight;
        this.horizontalWeight = constraintSet$Layout.horizontalWeight;
        this.horizontalChainStyle = constraintSet$Layout.horizontalChainStyle;
        this.verticalChainStyle = constraintSet$Layout.verticalChainStyle;
        this.widthDefault = constraintSet$Layout.widthDefault;
        this.heightDefault = constraintSet$Layout.heightDefault;
        this.widthMax = constraintSet$Layout.widthMax;
        this.heightMax = constraintSet$Layout.heightMax;
        this.widthMin = constraintSet$Layout.widthMin;
        this.heightMin = constraintSet$Layout.heightMin;
        this.widthPercent = constraintSet$Layout.widthPercent;
        this.heightPercent = constraintSet$Layout.heightPercent;
        this.mBarrierDirection = constraintSet$Layout.mBarrierDirection;
        this.mBarrierMargin = constraintSet$Layout.mBarrierMargin;
        this.mHelperType = constraintSet$Layout.mHelperType;
        this.mConstraintTag = constraintSet$Layout.mConstraintTag;
        int[] iArr = constraintSet$Layout.mReferenceIds;
        if (iArr != null) {
            this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.mReferenceIds = null;
        }
        this.mReferenceIdString = constraintSet$Layout.mReferenceIdString;
        this.constrainedWidth = constraintSet$Layout.constrainedWidth;
        this.constrainedHeight = constraintSet$Layout.constrainedHeight;
        this.mBarrierAllowsGoneWidgets = constraintSet$Layout.mBarrierAllowsGoneWidgets;
    }

    public void dump(MotionScene motionScene, StringBuilder sb) {
        Field[] declaredFields = getClass().getDeclaredFields();
        sb.append("\n");
        for (Field field : declaredFields) {
            String name = field.getName();
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    Object obj = field.get(this);
                    Class<?> type = field.getType();
                    if (type == Integer.TYPE) {
                        Integer num = (Integer) obj;
                        if (num.intValue() != -1) {
                            Object objLookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                            sb.append("    ");
                            sb.append(name);
                            sb.append(" = \"");
                            sb.append(objLookUpConstraintName == null ? num : objLookUpConstraintName);
                            sb.append("\"\n");
                        }
                    } else if (type == Float.TYPE) {
                        Float f = (Float) obj;
                        if (f.floatValue() != -1.0f) {
                            sb.append("    ");
                            sb.append(name);
                            sb.append(" = \"");
                            sb.append(f);
                            sb.append("\"\n");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
        this.mApply = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = mapToConstant.get(index);
            if (i2 == 80) {
                this.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedWidth);
            } else if (i2 != 81) {
                switch (i2) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = typedArrayObtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    default:
                        switch (i2) {
                            case 54:
                                this.widthDefault = typedArrayObtainStyledAttributes.getInt(index, this.widthDefault);
                                break;
                            case 55:
                                this.heightDefault = typedArrayObtainStyledAttributes.getInt(index, this.heightDefault);
                                break;
                            case 56:
                                this.widthMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                break;
                            case 57:
                                this.heightMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                break;
                            case 58:
                                this.widthMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                break;
                            case 59:
                                this.heightMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                break;
                            default:
                                switch (i2) {
                                    case 61:
                                        this.circleConstraint = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.circleConstraint);
                                        break;
                                    case 62:
                                        this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                        break;
                                    case 63:
                                        this.circleAngle = typedArrayObtainStyledAttributes.getFloat(index, this.circleAngle);
                                        break;
                                    default:
                                        switch (i2) {
                                            case 69:
                                                this.widthPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.heightPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 71:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.mBarrierDirection = typedArrayObtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                break;
                                            case 73:
                                                this.mBarrierMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                break;
                                            case 74:
                                                this.mReferenceIdString = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            case 75:
                                                this.mBarrierAllowsGoneWidgets = typedArrayObtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                break;
                                            case 76:
                                                StringBuilder sbU = a.U("unused attribute 0x");
                                                sbU.append(Integer.toHexString(index));
                                                sbU.append("   ");
                                                sbU.append(mapToConstant.get(index));
                                                Log.w("ConstraintSet", sbU.toString());
                                                break;
                                            case 77:
                                                this.mConstraintTag = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                StringBuilder sbU2 = a.U("Unknown attribute 0x");
                                                sbU2.append(Integer.toHexString(index));
                                                sbU2.append("   ");
                                                sbU2.append(mapToConstant.get(index));
                                                Log.w("ConstraintSet", sbU2.toString());
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                this.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedHeight);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
