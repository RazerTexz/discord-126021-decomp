package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager$AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.os.Build$VERSION;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import b.d.b.a.a;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final Charset ASCII;
    public static final short BYTE_ALIGN_II = 18761;
    public static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final ExifInterface$ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifInterface$ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifInterface$ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifInterface$ExifTag[] IFD_GPS_TAGS;
    private static final ExifInterface$ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifInterface$ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifInterface$ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    public static final int IFD_TYPE_PREVIEW = 5;
    public static final int IFD_TYPE_PRIMARY = 0;
    public static final int IFD_TYPE_THUMBNAIL = 4;
    public static final int IMAGE_TYPE_ARW = 1;
    public static final int IMAGE_TYPE_CR2 = 2;
    public static final int IMAGE_TYPE_DNG = 3;
    public static final int IMAGE_TYPE_HEIF = 12;
    public static final int IMAGE_TYPE_JPEG = 4;
    public static final int IMAGE_TYPE_NEF = 5;
    public static final int IMAGE_TYPE_NRW = 6;
    public static final int IMAGE_TYPE_ORF = 7;
    public static final int IMAGE_TYPE_PEF = 8;
    public static final int IMAGE_TYPE_PNG = 13;
    public static final int IMAGE_TYPE_RAF = 9;
    public static final int IMAGE_TYPE_RW2 = 10;
    public static final int IMAGE_TYPE_SRW = 11;
    public static final int IMAGE_TYPE_UNKNOWN = 0;
    public static final int IMAGE_TYPE_WEBP = 14;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte MARKER = -1;
    public static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    public static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN;
    private static final ExifInterface$ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifInterface$ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifInterface$ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifInterface$ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifInterface$ExifTag TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte WEBP_VP8L_SIGNATURE = 47;

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap;
    private static final HashMap<Integer, ExifInterface$ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifInterface$ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager$AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifInterface$ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;
    private static final String TAG = "ExifInterface";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte MARKER_SOI = -40;
    public static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    public static final byte START_CODE = 42;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};

    static {
        ExifInterface$ExifTag[] exifInterface$ExifTagArr = {new ExifInterface$ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifInterface$ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifInterface$ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifInterface$ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifInterface$ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifInterface$ExifTag(TAG_COMPRESSION, 259, 3), new ExifInterface$ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifInterface$ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifInterface$ExifTag(TAG_MAKE, 271, 2), new ExifInterface$ExifTag(TAG_MODEL, 272, 2), new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3, 4), new ExifInterface$ExifTag(TAG_ORIENTATION, 274, 3), new ExifInterface$ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifInterface$ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifInterface$ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifInterface$ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifInterface$ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifInterface$ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifInterface$ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifInterface$ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifInterface$ExifTag(TAG_SOFTWARE, 305, 2), new ExifInterface$ExifTag(TAG_DATETIME, 306, 2), new ExifInterface$ExifTag(TAG_ARTIST, 315, 2), new ExifInterface$ExifTag(TAG_WHITE_POINT, 318, 5), new ExifInterface$ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifInterface$ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifInterface$ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifInterface$ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifInterface$ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifInterface$ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifInterface$ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifInterface$ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifInterface$ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifInterface$ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifInterface$ExifTag(TAG_RW2_ISO, 23, 3), new ExifInterface$ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifInterface$ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = exifInterface$ExifTagArr;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr2 = {new ExifInterface$ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifInterface$ExifTag(TAG_F_NUMBER, 33437, 5), new ExifInterface$ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifInterface$ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifInterface$ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifInterface$ExifTag(TAG_OECF, 34856, 7), new ExifInterface$ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifInterface$ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifInterface$ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifInterface$ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifInterface$ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifInterface$ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifInterface$ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifInterface$ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifInterface$ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifInterface$ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifInterface$ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifInterface$ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifInterface$ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifInterface$ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifInterface$ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifInterface$ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifInterface$ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifInterface$ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifInterface$ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifInterface$ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifInterface$ExifTag(TAG_METERING_MODE, 37383, 3), new ExifInterface$ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifInterface$ExifTag(TAG_FLASH, 37385, 3), new ExifInterface$ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifInterface$ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifInterface$ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifInterface$ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifInterface$ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifInterface$ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifInterface$ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifInterface$ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifInterface$ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifInterface$ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifInterface$ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifInterface$ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifInterface$ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifInterface$ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifInterface$ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifInterface$ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifInterface$ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifInterface$ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifInterface$ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifInterface$ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifInterface$ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifInterface$ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifInterface$ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifInterface$ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifInterface$ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifInterface$ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifInterface$ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifInterface$ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifInterface$ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifInterface$ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifInterface$ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifInterface$ExifTag(TAG_CONTRAST, 41992, 3), new ExifInterface$ExifTag(TAG_SATURATION, 41993, 3), new ExifInterface$ExifTag(TAG_SHARPNESS, 41994, 3), new ExifInterface$ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifInterface$ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifInterface$ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifInterface$ExifTag("CameraOwnerName", 42032, 2), new ExifInterface$ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifInterface$ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifInterface$ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifInterface$ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifInterface$ExifTag(TAG_GAMMA, 42240, 5), new ExifInterface$ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifInterface$ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = exifInterface$ExifTagArr2;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr3 = {new ExifInterface$ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifInterface$ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifInterface$ExifTag(TAG_GPS_LATITUDE, 2, 5, 10), new ExifInterface$ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifInterface$ExifTag(TAG_GPS_LONGITUDE, 4, 5, 10), new ExifInterface$ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifInterface$ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifInterface$ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifInterface$ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifInterface$ExifTag(TAG_GPS_STATUS, 9, 2), new ExifInterface$ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifInterface$ExifTag(TAG_GPS_DOP, 11, 5), new ExifInterface$ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifInterface$ExifTag(TAG_GPS_SPEED, 13, 5), new ExifInterface$ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifInterface$ExifTag(TAG_GPS_TRACK, 15, 5), new ExifInterface$ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifInterface$ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifInterface$ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifInterface$ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifInterface$ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifInterface$ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifInterface$ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifInterface$ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifInterface$ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifInterface$ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifInterface$ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifInterface$ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifInterface$ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifInterface$ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifInterface$ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifInterface$ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = exifInterface$ExifTagArr3;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr4 = {new ExifInterface$ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifInterface$ExifTagArr4;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr5 = {new ExifInterface$ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifInterface$ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifInterface$ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifInterface$ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifInterface$ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifInterface$ExifTag(TAG_COMPRESSION, 259, 3), new ExifInterface$ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifInterface$ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifInterface$ExifTag(TAG_MAKE, 271, 2), new ExifInterface$ExifTag(TAG_MODEL, 272, 2), new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3, 4), new ExifInterface$ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifInterface$ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifInterface$ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifInterface$ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifInterface$ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifInterface$ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifInterface$ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifInterface$ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifInterface$ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifInterface$ExifTag(TAG_SOFTWARE, 305, 2), new ExifInterface$ExifTag(TAG_DATETIME, 306, 2), new ExifInterface$ExifTag(TAG_ARTIST, 315, 2), new ExifInterface$ExifTag(TAG_WHITE_POINT, 318, 5), new ExifInterface$ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifInterface$ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifInterface$ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifInterface$ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifInterface$ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifInterface$ExifTag(TAG_XMP, 700, 1), new ExifInterface$ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifInterface$ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifInterface$ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifInterface$ExifTagArr5;
        TAG_RAF_IMAGE_SIZE = new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3);
        ExifInterface$ExifTag[] exifInterface$ExifTagArr6 = {new ExifInterface$ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifInterface$ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifInterface$ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifInterface$ExifTagArr6;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr7 = {new ExifInterface$ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifInterface$ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifInterface$ExifTagArr7;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr8 = {new ExifInterface$ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifInterface$ExifTagArr8;
        ExifInterface$ExifTag[] exifInterface$ExifTagArr9 = {new ExifInterface$ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifInterface$ExifTagArr9;
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr10 = {exifInterface$ExifTagArr, exifInterface$ExifTagArr2, exifInterface$ExifTagArr3, exifInterface$ExifTagArr4, exifInterface$ExifTagArr5, exifInterface$ExifTagArr, exifInterface$ExifTagArr6, exifInterface$ExifTagArr7, exifInterface$ExifTagArr8, exifInterface$ExifTagArr9};
        EXIF_TAGS = exifInterface$ExifTagArr10;
        EXIF_POINTER_TAGS = new ExifInterface$ExifTag[]{new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifInterface$ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifInterface$ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifInterface$ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        sExifTagMapsForReading = new HashMap[exifInterface$ExifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifInterface$ExifTagArr10.length];
        sTagSetForCompatibility = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
        sExifPointerTagMap = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        ASCII = charsetForName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(charsetForName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ExifInterface$ExifTag[][] exifInterface$ExifTagArr11 = EXIF_TAGS;
            if (i >= exifInterface$ExifTagArr11.length) {
                HashMap<Integer, Integer> map = sExifPointerTagMap;
                ExifInterface$ExifTag[] exifInterface$ExifTagArr12 = EXIF_POINTER_TAGS;
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[0].number), 5);
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[1].number), 1);
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[2].number), 2);
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[3].number), 3);
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[4].number), 7);
                map.put(Integer.valueOf(exifInterface$ExifTagArr12[5].number), 8);
                NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            sExifTagMapsForReading[i] = new HashMap<>();
            sExifTagMapsForWriting[i] = new HashMap<>();
            for (ExifInterface$ExifTag exifInterface$ExifTag : exifInterface$ExifTagArr11[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifInterface$ExifTag.number), exifInterface$ExifTag);
                sExifTagMapsForWriting[i].put(exifInterface$ExifTag.name, exifInterface$ExifTag);
            }
            i++;
        }
    }

    public ExifInterface(@NonNull File file) throws Throwable {
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifInterface$ExifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifInterface$ExifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(file, "file cannot be null");
        initForFilename(file.getAbsolutePath());
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifInterface$ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - j;
        long j2 = (long) (d2 * 60.0d);
        return j + "/1," + j2 + "/1," + Math.round((d2 - (j2 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] strArrSplit = str.split(",", -1);
            String[] strArrSplit2 = strArrSplit[0].split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, -1);
            double d = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, -1);
            double d2 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, -1);
            double d3 = ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d) + (d2 / 60.0d) + d;
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new IllegalArgumentException();
                }
                return d3;
            }
            return -d3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void copyChunksUpToGivenChunkType(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String string;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (exifInterface$ByteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sbU = a.U("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = ASCII;
                sbU.append(new String(bArr, charset));
                if (bArr2 == null) {
                    string = "";
                } else {
                    StringBuilder sbU2 = a.U(" or ");
                    sbU2.append(new String(bArr2, charset));
                    string = sbU2.toString();
                }
                sbU.append(string);
                throw new IOException(sbU.toString());
            }
            copyWebPChunk(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int i = exifInterface$ByteOrderedDataInputStream.readInt();
        exifInterface$ByteOrderedDataOutputStream.write(bArr);
        exifInterface$ByteOrderedDataOutputStream.writeInt(i);
        if (i % 2 == 1) {
            i++;
        }
        ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, i);
    }

    @Nullable
    private ExifInterface$ExifAttribute getExifAttribute(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            if (DEBUG) {
                Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[i].get(str);
            if (exifInterface$ExifAttribute != null) {
                return exifInterface$ExifAttribute;
            }
        }
        return null;
    }

    private void getHeifAttributes(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        if (Build$VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                ExifInterfaceUtils$Api23Impl.setDataSource(mediaMetadataRetriever, new ExifInterface$1(this, exifInterface$SeekableByteOrderedDataInputStream));
                String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(17);
                String strExtractMetadata7 = null;
                if ("yes".equals(strExtractMetadata5)) {
                    strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                }
                if (strExtractMetadata7 != null) {
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifInterface$ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata7), this.mExifByteOrder));
                }
                if (strExtractMetadata != null) {
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifInterface$ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata), this.mExifByteOrder));
                }
                if (strExtractMetadata2 != null) {
                    int i = 1;
                    int i2 = Integer.parseInt(strExtractMetadata2);
                    if (i2 == 90) {
                        i = 6;
                    } else if (i2 == 180) {
                        i = 3;
                    } else if (i2 == 270) {
                        i = 8;
                    }
                    this.mAttributes[0].put(TAG_ORIENTATION, ExifInterface$ExifAttribute.createUShort(i, this.mExifByteOrder));
                }
                if (strExtractMetadata3 != null && strExtractMetadata4 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata3);
                    int i4 = Integer.parseInt(strExtractMetadata4);
                    if (i4 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    exifInterface$SeekableByteOrderedDataInputStream.seek(i3);
                    byte[] bArr = new byte[6];
                    if (exifInterface$SeekableByteOrderedDataInputStream.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i5 = i3 + 6;
                    int i6 = i4 - 6;
                    if (!Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    if (exifInterface$SeekableByteOrderedDataInputStream.read(bArr2) != i6) {
                        throw new IOException("Can't read exif");
                    }
                    this.mOffsetToExifData = i5;
                    readExifSegment(bArr2, 0);
                }
                if (DEBUG) {
                    Log.d(TAG, "Heif meta: " + strExtractMetadata7 + "x" + strExtractMetadata + ", rotation " + strExtractMetadata2);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b0 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:61:0x016c A[LOOP:0: B:10:0x0038->B:61:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0174 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r19, int r20, int r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(SIGNATURE_CHECK_SIZE);
        byte[] bArr = new byte[SIGNATURE_CHECK_SIZE];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private void getOrfAttributes(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) throws Throwable {
        getRawAttributes(exifInterface$SeekableByteOrderedDataInputStream);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifInterface$ExifAttribute != null) {
            ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream2 = new ExifInterface$SeekableByteOrderedDataInputStream(exifInterface$ExifAttribute.bytes);
            exifInterface$SeekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            exifInterface$SeekableByteOrderedDataInputStream2.readFully(bArr2);
            exifInterface$SeekableByteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            exifInterface$SeekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                exifInterface$SeekableByteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                exifInterface$SeekableByteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream2, 6);
            ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifInterface$ExifAttribute2 != null && exifInterface$ExifAttribute3 != null) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifInterface$ExifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifInterface$ExifAttribute3);
            }
            ExifInterface$ExifAttribute exifInterface$ExifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifInterface$ExifAttribute4 != null) {
                int[] iArr = (int[]) exifInterface$ExifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sbU = a.U("Invalid aspect frame values. frame=");
                    sbU.append(Arrays.toString(iArr));
                    Log.w(TAG, sbU.toString());
                } else {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort = ExifInterface$ExifAttribute.createUShort(i, this.mExifByteOrder);
                    ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort2 = ExifInterface$ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifInterface$ExifAttributeCreateUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifInterface$ExifAttributeCreateUShort2);
                }
            }
        }
    }

    private void getPngAttributes(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d(TAG, "getPngAttributes starting with: " + exifInterface$ByteOrderedDataInputStream);
        }
        exifInterface$ByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        exifInterface$ByteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int i = exifInterface$ByteOrderedDataInputStream.readInt();
                int i2 = length + 4;
                byte[] bArr2 = new byte[4];
                if (exifInterface$ByteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i3 = i2 + 4;
                if (i3 == 16 && !Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                    byte[] bArr3 = new byte[i];
                    if (exifInterface$ByteOrderedDataInputStream.read(bArr3) != i) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                    int i4 = exifInterface$ByteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i4) {
                        this.mOffsetToExifData = i3;
                        readExifSegment(bArr3, 0);
                        validateImages();
                        setThumbnailData(new ExifInterface$ByteOrderedDataInputStream(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i4 + ", calculated CRC value: " + crc32.getValue());
                }
                int i5 = i + 4;
                exifInterface$ByteOrderedDataInputStream.skipFully(i5);
                length = i3 + i5;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws Throwable {
        boolean z2 = DEBUG;
        if (z2) {
            Log.d(TAG, "getRafAttributes starting with: " + exifInterface$ByteOrderedDataInputStream);
        }
        exifInterface$ByteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        exifInterface$ByteOrderedDataInputStream.read(bArr);
        exifInterface$ByteOrderedDataInputStream.read(bArr2);
        exifInterface$ByteOrderedDataInputStream.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        exifInterface$ByteOrderedDataInputStream.skipFully(i - exifInterface$ByteOrderedDataInputStream.position());
        exifInterface$ByteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ExifInterface$ByteOrderedDataInputStream(bArr4), i, 5);
        exifInterface$ByteOrderedDataInputStream.skipFully(i3 - exifInterface$ByteOrderedDataInputStream.position());
        exifInterface$ByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int i4 = exifInterface$ByteOrderedDataInputStream.readInt();
        if (z2) {
            a.n0("numberOfDirectoryEntry: ", i4, TAG);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = exifInterface$ByteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = exifInterface$ByteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short s2 = exifInterface$ByteOrderedDataInputStream.readShort();
                short s3 = exifInterface$ByteOrderedDataInputStream.readShort();
                ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort = ExifInterface$ExifAttribute.createUShort(s2, this.mExifByteOrder);
                ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort2 = ExifInterface$ExifAttribute.createUShort(s3, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifInterface$ExifAttributeCreateUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifInterface$ExifAttributeCreateUShort2);
                if (DEBUG) {
                    Log.d(TAG, "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            exifInterface$ByteOrderedDataInputStream.skipFully(unsignedShort2);
        }
    }

    private void getRawAttributes(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) throws Throwable {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute;
        parseTiffHeaders(exifInterface$SeekableByteOrderedDataInputStream);
        readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(exifInterface$SeekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(exifInterface$SeekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(exifInterface$SeekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType != 8 || (exifInterface$ExifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) == null) {
            return;
        }
        ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream2 = new ExifInterface$SeekableByteOrderedDataInputStream(exifInterface$ExifAttribute.bytes);
        exifInterface$SeekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
        exifInterface$SeekableByteOrderedDataInputStream2.skipFully(6);
        readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream2, 9);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
        if (exifInterface$ExifAttribute2 != null) {
            this.mAttributes[1].put(TAG_COLOR_SPACE, exifInterface$ExifAttribute2);
        }
    }

    private void getRw2Attributes(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d(TAG, "getRw2Attributes starting with: " + exifInterface$SeekableByteOrderedDataInputStream);
        }
        getRawAttributes(exifInterface$SeekableByteOrderedDataInputStream);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifInterface$ExifAttribute != null) {
            getJpegAttributes(new ExifInterface$ByteOrderedDataInputStream(exifInterface$ExifAttribute.bytes), (int) exifInterface$ExifAttribute.bytesOffset, 5);
        }
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifInterface$ExifAttribute2 == null || exifInterface$ExifAttribute3 != null) {
            return;
        }
        this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifInterface$ExifAttribute2);
    }

    private void getStandaloneAttributes(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        exifInterface$SeekableByteOrderedDataInputStream.skipFully(bArr.length);
        byte[] bArr2 = new byte[exifInterface$SeekableByteOrderedDataInputStream.available()];
        exifInterface$SeekableByteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d(TAG, "getWebpAttributes starting with: " + exifInterface$ByteOrderedDataInputStream);
        }
        exifInterface$ByteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        exifInterface$ByteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int i = exifInterface$ByteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        exifInterface$ByteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (exifInterface$ByteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = exifInterface$ByteOrderedDataInputStream.readInt();
                int i3 = length + 4 + 4;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    if (exifInterface$ByteOrderedDataInputStream.read(bArr3) == i2) {
                        this.mOffsetToExifData = i3;
                        readExifSegment(bArr3, 0);
                        setThumbnailData(new ExifInterface$ByteOrderedDataInputStream(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                exifInterface$ByteOrderedDataInputStream.skipFully(i2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair<Integer, Integer> guessDataFormat(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair<Integer, Integer> pairGuessDataFormat = guessDataFormat(strArrSplit[0]);
            if (((Integer) pairGuessDataFormat.first).intValue() == 2) {
                return pairGuessDataFormat;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair<Integer, Integer> pairGuessDataFormat2 = guessDataFormat(strArrSplit[i]);
                int iIntValue = (((Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.first) || ((Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.first)) ? ((Integer) pairGuessDataFormat.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairGuessDataFormat.second).intValue() == -1 || !(((Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.second) || ((Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.second))) ? -1 : ((Integer) pairGuessDataFormat.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (iIntValue == -1) {
                    pairGuessDataFormat = new Pair<>(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairGuessDataFormat = new Pair<>(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairGuessDataFormat;
        }
        if (!str.contains(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
            try {
                try {
                    Long lValueOf = Long.valueOf(Long.parseLong(str));
                    if (lValueOf.longValue() < 0 || lValueOf.longValue() > 65535) {
                        return lValueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1);
                    }
                    return new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair<>(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair<>(12, -1);
            }
        }
        String[] strArrSplit2 = str.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, -1);
        if (strArrSplit2.length == 2) {
            try {
                long j = (long) Double.parseDouble(strArrSplit2[0]);
                long j2 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j >= 0 && j2 >= 0) {
                    if (j <= 2147483647L && j2 <= 2147483647L) {
                        return new Pair<>(10, 5);
                    }
                    return new Pair<>(5, -1);
                }
                return new Pair<>(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair<>(2, -1);
    }

    private void handleThumbnailFromJfif(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, HashMap map) throws Throwable {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute) map.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = (ExifInterface$ExifAttribute) map.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifInterface$ExifAttribute == null || exifInterface$ExifAttribute2 == null) {
            return;
        }
        int intValue = exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifInterface$ExifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        if (intValue > 0 && intValue2 > 0) {
            this.mHasThumbnail = true;
            if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                byte[] bArr = new byte[intValue2];
                exifInterface$ByteOrderedDataInputStream.skip(intValue);
                exifInterface$ByteOrderedDataInputStream.read(bArr);
                this.mThumbnailBytes = bArr;
            }
            this.mThumbnailOffset = intValue;
            this.mThumbnailLength = intValue2;
        }
        if (DEBUG) {
            Log.d(TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2);
        }
    }

    private void handleThumbnailFromStrips(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, HashMap map) throws IOException {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute) map.get(TAG_STRIP_OFFSETS);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = (ExifInterface$ExifAttribute) map.get(TAG_STRIP_BYTE_COUNTS);
        if (exifInterface$ExifAttribute == null || exifInterface$ExifAttribute2 == null) {
            return;
        }
        long[] jArrConvertToLongArray = ExifInterfaceUtils.convertToLongArray(exifInterface$ExifAttribute.getValue(this.mExifByteOrder));
        long[] jArrConvertToLongArray2 = ExifInterfaceUtils.convertToLongArray(exifInterface$ExifAttribute2.getValue(this.mExifByteOrder));
        if (jArrConvertToLongArray == null || jArrConvertToLongArray.length == 0) {
            Log.w(TAG, "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrConvertToLongArray2 == null || jArrConvertToLongArray2.length == 0) {
            Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrConvertToLongArray.length != jArrConvertToLongArray2.length) {
            Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j = 0;
        for (long j2 : jArrConvertToLongArray2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 1;
        this.mAreThumbnailStripsConsecutive = true;
        this.mHasThumbnailStrips = true;
        this.mHasThumbnail = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < jArrConvertToLongArray.length) {
            int i6 = (int) jArrConvertToLongArray[i3];
            int i7 = (int) jArrConvertToLongArray2[i3];
            if (i3 < jArrConvertToLongArray.length - i2 && i6 + i7 != jArrConvertToLongArray[i3 + 1]) {
                this.mAreThumbnailStripsConsecutive = false;
            }
            int i8 = i6 - i4;
            if (i8 < 0) {
                Log.d(TAG, "Invalid strip offset value");
                return;
            }
            long j3 = i8;
            if (exifInterface$ByteOrderedDataInputStream.skip(j3) != j3) {
                Log.d(TAG, "Failed to skip " + i8 + " bytes.");
                return;
            }
            int i9 = i4 + i8;
            byte[] bArr2 = new byte[i7];
            if (exifInterface$ByteOrderedDataInputStream.read(bArr2) != i7) {
                Log.d(TAG, "Failed to read " + i7 + " bytes.");
                return;
            }
            i4 = i9 + i7;
            System.arraycopy(bArr2, 0, bArr, i5, i7);
            i5 += i7;
            i3++;
            i2 = 1;
        }
        this.mThumbnailBytes = bArr;
        if (this.mAreThumbnailStripsConsecutive) {
            this.mThumbnailOffset = (int) jArrConvertToLongArray[0];
            this.mThumbnailLength = i;
        }
    }

    private void initForFilename(String str) throws Throwable {
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream = null;
        this.mAssetInputStream = null;
        this.mFilename = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (isSeekableFD(fileInputStream2.getFD())) {
                    this.mSeekableFileDescriptor = fileInputStream2.getFD();
                } else {
                    this.mSeekableFileDescriptor = null;
                }
                loadAttributes(fileInputStream2);
                ExifInterfaceUtils.closeQuietly(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                ExifInterfaceUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isHeifFormat(byte[] bArr) throws Throwable {
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = null;
        try {
            try {
                ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream2 = new ExifInterface$ByteOrderedDataInputStream(bArr);
                try {
                    long length = exifInterface$ByteOrderedDataInputStream2.readInt();
                    byte[] bArr2 = new byte[4];
                    exifInterface$ByteOrderedDataInputStream2.read(bArr2);
                    if (!Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
                        exifInterface$ByteOrderedDataInputStream2.close();
                        return false;
                    }
                    long j = 16;
                    if (length == 1) {
                        length = exifInterface$ByteOrderedDataInputStream2.readLong();
                        if (length < 16) {
                            exifInterface$ByteOrderedDataInputStream2.close();
                            return false;
                        }
                    } else {
                        j = 8;
                    }
                    if (length > bArr.length) {
                        length = bArr.length;
                    }
                    long j2 = length - j;
                    if (j2 < 8) {
                        exifInterface$ByteOrderedDataInputStream2.close();
                        return false;
                    }
                    byte[] bArr3 = new byte[4];
                    boolean z2 = false;
                    boolean z3 = false;
                    for (long j3 = 0; j3 < j2 / 4; j3++) {
                        if (exifInterface$ByteOrderedDataInputStream2.read(bArr3) != 4) {
                            exifInterface$ByteOrderedDataInputStream2.close();
                            return false;
                        }
                        if (j3 != 1) {
                            if (Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                                z2 = true;
                            } else if (Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                                z3 = true;
                            }
                            if (z2 && z3) {
                                exifInterface$ByteOrderedDataInputStream2.close();
                                return true;
                            }
                        }
                    }
                    exifInterface$ByteOrderedDataInputStream2.close();
                } catch (Exception e) {
                    e = e;
                    exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                    if (DEBUG) {
                        Log.d(TAG, "Exception parsing HEIF file type box.", e);
                    }
                    if (exifInterface$ByteOrderedDataInputStream != null) {
                        exifInterface$ByteOrderedDataInputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                    if (exifInterface$ByteOrderedDataInputStream != null) {
                        exifInterface$ByteOrderedDataInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws Throwable {
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = null;
        try {
            ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream2 = new ExifInterface$ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder byteOrder = readByteOrder(exifInterface$ByteOrderedDataInputStream2);
                this.mExifByteOrder = byteOrder;
                exifInterface$ByteOrderedDataInputStream2.setByteOrder(byteOrder);
                short s2 = exifInterface$ByteOrderedDataInputStream2.readShort();
                boolean z2 = s2 == 20306 || s2 == 21330;
                exifInterface$ByteOrderedDataInputStream2.close();
                return z2;
            } catch (Exception unused) {
                exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                if (exifInterface$ByteOrderedDataInputStream != null) {
                    exifInterface$ByteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                if (exifInterface$ByteOrderedDataInputStream != null) {
                    exifInterface$ByteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) throws Throwable {
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = null;
        try {
            ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream2 = new ExifInterface$ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder byteOrder = readByteOrder(exifInterface$ByteOrderedDataInputStream2);
                this.mExifByteOrder = byteOrder;
                exifInterface$ByteOrderedDataInputStream2.setByteOrder(byteOrder);
                boolean z2 = exifInterface$ByteOrderedDataInputStream2.readShort() == 85;
                exifInterface$ByteOrderedDataInputStream2.close();
                return z2;
            } catch (Exception unused) {
                exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                if (exifInterface$ByteOrderedDataInputStream != null) {
                    exifInterface$ByteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                exifInterface$ByteOrderedDataInputStream = exifInterface$ByteOrderedDataInputStream2;
                if (exifInterface$ByteOrderedDataInputStream != null) {
                    exifInterface$ByteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils$Api21Impl.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!DEBUG) {
                return false;
            }
            Log.d(TAG, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap map) throws IOException {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute;
        int intValue;
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = (ExifInterface$ExifAttribute) map.get(TAG_BITS_PER_SAMPLE);
        if (exifInterface$ExifAttribute2 != null) {
            int[] iArr = (int[]) exifInterface$ExifAttribute2.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifInterface$ExifAttribute = (ExifInterface$ExifAttribute) map.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((intValue = exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "Unsupported data type value");
        return false;
    }

    private static boolean isSupportedFormatForSavingAttributes(int i) {
        return i == 4 || i == 13 || i == 14 || i == 3 || i == 0;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        Objects.requireNonNull(str, "mimeType shouldn't be null");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "image/x-fuji-raf":
            case "image/x-samsung-srw":
            case "image/x-sony-arw":
            case "image/heic":
            case "image/heif":
            case "image/jpeg":
            case "image/webp":
            case "image/x-adobe-dng":
            case "image/x-panasonic-rw2":
            case "image/png":
            case "image/x-pentax-pef":
            case "image/x-olympus-orf":
            case "image/x-nikon-nef":
            case "image/x-nikon-nrw":
            case "image/x-canon-cr2":
                return true;
            default:
                return false;
        }
    }

    private boolean isThumbnail(HashMap map) throws IOException {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute) map.get(TAG_IMAGE_LENGTH);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = (ExifInterface$ExifAttribute) map.get(TAG_IMAGE_WIDTH);
        if (exifInterface$ExifAttribute == null || exifInterface$ExifAttribute2 == null) {
            return false;
        }
        return exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifInterface$ExifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    private void loadAttributes(@NonNull InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new HashMap<>();
                } catch (Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th;
                }
            } catch (IOException | UnsupportedOperationException e) {
                boolean z2 = DEBUG;
                if (z2) {
                    Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (!z2) {
                    return;
                }
            }
        }
        if (!this.mIsExifDataOnly) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, SIGNATURE_CHECK_SIZE);
            this.mMimeType = getMimeType(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (shouldSupportSeek(this.mMimeType)) {
            ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream = new ExifInterface$SeekableByteOrderedDataInputStream(inputStream);
            if (this.mIsExifDataOnly) {
                getStandaloneAttributes(exifInterface$SeekableByteOrderedDataInputStream);
            } else {
                int i2 = this.mMimeType;
                if (i2 == 12) {
                    getHeifAttributes(exifInterface$SeekableByteOrderedDataInputStream);
                } else if (i2 == 7) {
                    getOrfAttributes(exifInterface$SeekableByteOrderedDataInputStream);
                } else if (i2 == 10) {
                    getRw2Attributes(exifInterface$SeekableByteOrderedDataInputStream);
                } else {
                    getRawAttributes(exifInterface$SeekableByteOrderedDataInputStream);
                }
            }
            exifInterface$SeekableByteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(exifInterface$SeekableByteOrderedDataInputStream);
        } else {
            ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(inputStream);
            int i3 = this.mMimeType;
            if (i3 == 4) {
                getJpegAttributes(exifInterface$ByteOrderedDataInputStream, 0, 0);
            } else if (i3 == 13) {
                getPngAttributes(exifInterface$ByteOrderedDataInputStream);
            } else if (i3 == 9) {
                getRafAttributes(exifInterface$ByteOrderedDataInputStream);
            } else if (i3 == 14) {
                getWebpAttributes(exifInterface$ByteOrderedDataInputStream);
            }
        }
        addDefaultValuesForCompatibility();
        if (!DEBUG) {
            return;
        }
        printAttributes();
    }

    private static Long parseDateTime(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null && NON_ZERO_TIME_PATTERN.matcher(str).matches()) {
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date date = sFormatterPrimary.parse(str, parsePosition);
                if (date == null && (date = sFormatterSecondary.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = date.getTime();
                if (str3 != null) {
                    int i = 1;
                    String strSubstring = str3.substring(0, 1);
                    int i2 = Integer.parseInt(str3.substring(1, 3));
                    int i3 = Integer.parseInt(str3.substring(4, 6));
                    if ((BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX.equals(strSubstring) || "-".equals(strSubstring)) && ":".equals(str3.substring(3, 4)) && i2 <= 14) {
                        int i4 = ((i2 * 60) + i3) * 60 * 1000;
                        if (!"-".equals(strSubstring)) {
                            i = -1;
                        }
                        time += (long) (i4 * i);
                    }
                }
                if (str2 != null) {
                    time += ExifInterfaceUtils.parseSubSeconds(str2);
                }
                return Long.valueOf(time);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    private void parseTiffHeaders(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws IOException {
        ByteOrder byteOrder = readByteOrder(exifInterface$ByteOrderedDataInputStream);
        this.mExifByteOrder = byteOrder;
        exifInterface$ByteOrderedDataInputStream.setByteOrder(byteOrder);
        int unsignedShort = exifInterface$ByteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            StringBuilder sbU = a.U("Invalid start code: ");
            sbU.append(Integer.toHexString(unsignedShort));
            throw new IOException(sbU.toString());
        }
        int i2 = exifInterface$ByteOrderedDataInputStream.readInt();
        if (i2 < 8) {
            throw new IOException(a.q("Invalid first Ifd offset: ", i2));
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            exifInterface$ByteOrderedDataInputStream.skipFully(i3);
        }
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            StringBuilder sbV = a.V("The size of tag group[", i, "]: ");
            sbV.append(this.mAttributes[i].size());
            Log.d(TAG, sbV.toString());
            for (Map$Entry<String, ExifInterface$ExifAttribute> map$Entry : this.mAttributes[i].entrySet()) {
                ExifInterface$ExifAttribute value = map$Entry.getValue();
                StringBuilder sbU = a.U("tagName: ");
                sbU.append(map$Entry.getKey());
                sbU.append(", tagType: ");
                sbU.append(value.toString());
                sbU.append(", tagValue: '");
                sbU.append(value.getStringValue(this.mExifByteOrder));
                sbU.append("'");
                Log.d(TAG, sbU.toString());
            }
        }
    }

    private ByteOrder readByteOrder(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws IOException {
        short s2 = exifInterface$ByteOrderedDataInputStream.readShort();
        if (s2 == 18761) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder sbU = a.U("Invalid byte order: ");
        sbU.append(Integer.toHexString(s2));
        throw new IOException(sbU.toString());
    }

    private void readExifSegment(byte[] bArr, int i) throws IOException {
        ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream = new ExifInterface$SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(exifInterface$SeekableByteOrderedDataInputStream);
        readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, i);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0281  */
    /* JADX WARN: Code duplicated, block: B:104:0x028b  */
    /* JADX WARN: Code duplicated, block: B:113:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:137:0x02bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    /* JADX WARN: Code duplicated, block: B:51:0x0108  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:56:0x011f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0122  */
    /* JADX WARN: Code duplicated, block: B:59:0x0125  */
    /* JADX WARN: Code duplicated, block: B:62:0x0169  */
    /* JADX WARN: Code duplicated, block: B:64:0x0170  */
    /* JADX WARN: Code duplicated, block: B:67:0x0182  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:92:0x0202 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0204  */
    /* JADX WARN: Code duplicated, block: B:94:0x0226 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0228  */
    /* JADX WARN: Code duplicated, block: B:97:0x0243  */
    /* JADX WARN: Code duplicated, block: B:99:0x0274  */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0182, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x0204, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x0228, please report this as an issue */
    private void readImageFileDirectory(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream, int i) throws IOException {
        short s2;
        short s3;
        long j;
        boolean z2;
        int i2;
        Integer num;
        long unsignedInt;
        int unsignedShort;
        int i3;
        this.mAttributesOffsets.add(Integer.valueOf(exifInterface$SeekableByteOrderedDataInputStream.mPosition));
        short s4 = exifInterface$SeekableByteOrderedDataInputStream.readShort();
        if (DEBUG) {
            a.n0("numberOfDirectoryEntry: ", s4, TAG);
        }
        if (s4 <= 0) {
            return;
        }
        char c = 0;
        short s5 = 0;
        while (s5 < s4) {
            int unsignedShort2 = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort3 = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedShort();
            int i4 = exifInterface$SeekableByteOrderedDataInputStream.readInt();
            long jPosition = ((long) exifInterface$SeekableByteOrderedDataInputStream.position()) + 4;
            ExifInterface$ExifTag exifInterface$ExifTag = sExifTagMapsForReading[i].get(Integer.valueOf(unsignedShort2));
            boolean z3 = DEBUG;
            if (z3) {
                Object[] objArr = new Object[5];
                objArr[c] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(unsignedShort2);
                objArr[2] = exifInterface$ExifTag != null ? exifInterface$ExifTag.name : null;
                objArr[3] = Integer.valueOf(unsignedShort3);
                objArr[4] = Integer.valueOf(i4);
                Log.d(TAG, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
            }
            if (exifInterface$ExifTag != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                    if (unsignedShort3 < iArr.length) {
                        if (exifInterface$ExifTag.isFormatCompatible(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = exifInterface$ExifTag.primaryFormat;
                            }
                            s2 = s4;
                            s3 = s5;
                            j = ((long) i4) * ((long) iArr[unsignedShort3]);
                            if (j < 0 || j > 2147483647L) {
                                if (z3) {
                                    a.n0("Skip the tag entry since the number of components is invalid: ", i4, TAG);
                                }
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else if (z3) {
                            StringBuilder sbU = a.U("Skip the tag entry since data format (");
                            sbU.append(IFD_FORMAT_NAMES[unsignedShort3]);
                            sbU.append(") is unexpected for tag: ");
                            sbU.append(exifInterface$ExifTag.name);
                            Log.d(TAG, sbU.toString());
                        }
                    }
                    if (z2) {
                        if (j > 4) {
                            i3 = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                            if (z3) {
                                a.n0("seek to data offset: ", i3, TAG);
                            }
                            if (this.mMimeType != 7) {
                                i2 = i4;
                            } else {
                                if (TAG_MAKER_NOTE.equals(exifInterface$ExifTag.name)) {
                                    this.mOrfMakerNoteOffset = i3;
                                } else if (i != 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifInterface$ExifTag.name)) {
                                    this.mOrfThumbnailOffset = i3;
                                    this.mOrfThumbnailLength = i4;
                                    ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort = ExifInterface$ExifAttribute.createUShort(6, this.mExifByteOrder);
                                    ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateULong = ExifInterface$ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                    i2 = i4;
                                    ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateULong2 = ExifInterface$ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                    this.mAttributes[4].put(TAG_COMPRESSION, exifInterface$ExifAttributeCreateUShort);
                                    this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, exifInterface$ExifAttributeCreateULong);
                                    this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifInterface$ExifAttributeCreateULong2);
                                }
                                i2 = i4;
                            }
                            exifInterface$SeekableByteOrderedDataInputStream.seek(i3);
                        } else {
                            i2 = i4;
                        }
                        num = sExifPointerTagMap.get(Integer.valueOf(unsignedShort2));
                        if (z3) {
                            Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j);
                        }
                        if (num != null) {
                            unsignedInt = -1;
                            if (unsignedShort3 != 3) {
                                if (unsignedShort3 == 4) {
                                    unsignedInt = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedInt();
                                } else if (unsignedShort3 == 8) {
                                    unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readShort();
                                } else if (unsignedShort3 != 9 || unsignedShort3 == 13) {
                                    unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                                }
                                if (z3) {
                                    Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                                }
                                if (unsignedInt > 0) {
                                    if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                                        exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                                        readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                                    } else if (z3) {
                                        Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                                    }
                                } else if (z3) {
                                    Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                                }
                                exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                            } else {
                                unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedShort();
                            }
                            unsignedInt = unsignedShort;
                            if (z3) {
                                Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                            }
                            if (unsignedInt > 0) {
                                if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                                    exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                                    readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                                } else if (z3) {
                                    Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                                }
                            } else if (z3) {
                                Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                            }
                            exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                        } else {
                            int iPosition = exifInterface$SeekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                            byte[] bArr = new byte[(int) j];
                            exifInterface$SeekableByteOrderedDataInputStream.readFully(bArr);
                            ExifInterface$ExifAttribute exifInterface$ExifAttribute = new ExifInterface$ExifAttribute(unsignedShort3, i2, iPosition, bArr);
                            this.mAttributes[i].put(exifInterface$ExifTag.name, exifInterface$ExifAttribute);
                            if (TAG_DNG_VERSION.equals(exifInterface$ExifTag.name)) {
                                this.mMimeType = 3;
                            }
                            if (((!TAG_MAKE.equals(exifInterface$ExifTag.name) || TAG_MODEL.equals(exifInterface$ExifTag.name)) && exifInterface$ExifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || (TAG_COMPRESSION.equals(exifInterface$ExifTag.name) && exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                this.mMimeType = 8;
                            }
                            if (exifInterface$SeekableByteOrderedDataInputStream.position() != jPosition) {
                                exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                            }
                        }
                    } else {
                        exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                    }
                    s5 = (short) (s3 + 1);
                    c = 0;
                    s4 = s2;
                }
                s2 = s4;
                s3 = s5;
                if (z3) {
                    a.n0("Skip the tag entry since data format is invalid: ", unsignedShort3, TAG);
                }
                j = 0;
                z2 = false;
                if (z2) {
                    exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                } else {
                    if (j > 4) {
                        i3 = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                        if (z3) {
                            a.n0("seek to data offset: ", i3, TAG);
                        }
                        if (this.mMimeType != 7) {
                            i2 = i4;
                        } else {
                            if (TAG_MAKER_NOTE.equals(exifInterface$ExifTag.name)) {
                                this.mOrfMakerNoteOffset = i3;
                            } else if (i != 6) {
                            }
                            i2 = i4;
                        }
                        exifInterface$SeekableByteOrderedDataInputStream.seek(i3);
                    } else {
                        i2 = i4;
                    }
                    num = sExifPointerTagMap.get(Integer.valueOf(unsignedShort2));
                    if (z3) {
                        Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j);
                    }
                    if (num != null) {
                        unsignedInt = -1;
                        if (unsignedShort3 != 3) {
                            if (unsignedShort3 == 4) {
                                unsignedInt = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedInt();
                            } else if (unsignedShort3 == 8) {
                                if (unsignedShort3 != 9) {
                                }
                                unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                            } else {
                                unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readShort();
                            }
                            if (z3) {
                                Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                            }
                            if (unsignedInt > 0) {
                                if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                                    exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                                    readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                                } else if (z3) {
                                    Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                                }
                            } else if (z3) {
                                Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                            }
                            exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                        } else {
                            unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedShort();
                        }
                        unsignedInt = unsignedShort;
                        if (z3) {
                            Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                        }
                        if (unsignedInt > 0) {
                            if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                                exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                                readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                            } else if (z3) {
                                Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                            }
                        } else if (z3) {
                            Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                        }
                        exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                    } else {
                        int iPosition2 = exifInterface$SeekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                        byte[] bArr2 = new byte[(int) j];
                        exifInterface$SeekableByteOrderedDataInputStream.readFully(bArr2);
                        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = new ExifInterface$ExifAttribute(unsignedShort3, i2, iPosition2, bArr2);
                        this.mAttributes[i].put(exifInterface$ExifTag.name, exifInterface$ExifAttribute2);
                        if (TAG_DNG_VERSION.equals(exifInterface$ExifTag.name)) {
                            this.mMimeType = 3;
                        }
                        if (!TAG_MAKE.equals(exifInterface$ExifTag.name)) {
                        }
                        this.mMimeType = 8;
                        if (exifInterface$SeekableByteOrderedDataInputStream.position() != jPosition) {
                            exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                        }
                    }
                }
                s5 = (short) (s3 + 1);
                c = 0;
                s4 = s2;
            } else if (z3) {
                a.n0("Skip the tag entry since tag number is not defined: ", unsignedShort2, TAG);
            }
            s2 = s4;
            s3 = s5;
            j = 0;
            z2 = false;
            if (z2) {
                exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
            } else {
                if (j > 4) {
                    i3 = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                    if (z3) {
                        a.n0("seek to data offset: ", i3, TAG);
                    }
                    if (this.mMimeType != 7) {
                        i2 = i4;
                    } else {
                        if (TAG_MAKER_NOTE.equals(exifInterface$ExifTag.name)) {
                            this.mOrfMakerNoteOffset = i3;
                        } else if (i != 6) {
                        }
                        i2 = i4;
                    }
                    exifInterface$SeekableByteOrderedDataInputStream.seek(i3);
                } else {
                    i2 = i4;
                }
                num = sExifPointerTagMap.get(Integer.valueOf(unsignedShort2));
                if (z3) {
                    Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j);
                }
                if (num != null) {
                    unsignedInt = -1;
                    if (unsignedShort3 != 3) {
                        if (unsignedShort3 == 4) {
                            unsignedInt = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedInt();
                        } else if (unsignedShort3 == 8) {
                            if (unsignedShort3 != 9) {
                            }
                            unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readInt();
                        } else {
                            unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readShort();
                        }
                        if (z3) {
                            Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                        }
                        if (unsignedInt > 0) {
                            if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                                exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                                readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                            } else if (z3) {
                                Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                            }
                        } else if (z3) {
                            Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                        }
                        exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                    } else {
                        unsignedShort = exifInterface$SeekableByteOrderedDataInputStream.readUnsignedShort();
                    }
                    unsignedInt = unsignedShort;
                    if (z3) {
                        Log.d(TAG, String.format("Offset: %d, tagName: %s", Long.valueOf(unsignedInt), exifInterface$ExifTag.name));
                    }
                    if (unsignedInt > 0) {
                        if (!this.mAttributesOffsets.contains(Integer.valueOf((int) unsignedInt))) {
                            exifInterface$SeekableByteOrderedDataInputStream.seek(unsignedInt);
                            readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, num.intValue());
                        } else if (z3) {
                            Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + ")");
                        }
                    } else if (z3) {
                        Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                    }
                    exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                } else {
                    int iPosition3 = exifInterface$SeekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                    byte[] bArr3 = new byte[(int) j];
                    exifInterface$SeekableByteOrderedDataInputStream.readFully(bArr3);
                    ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = new ExifInterface$ExifAttribute(unsignedShort3, i2, iPosition3, bArr3);
                    this.mAttributes[i].put(exifInterface$ExifTag.name, exifInterface$ExifAttribute3);
                    if (TAG_DNG_VERSION.equals(exifInterface$ExifTag.name)) {
                        this.mMimeType = 3;
                    }
                    if (!TAG_MAKE.equals(exifInterface$ExifTag.name)) {
                    }
                    this.mMimeType = 8;
                    if (exifInterface$SeekableByteOrderedDataInputStream.position() != jPosition) {
                        exifInterface$SeekableByteOrderedDataInputStream.seek(jPosition);
                    }
                }
            }
            s5 = (short) (s3 + 1);
            c = 0;
            s4 = s2;
        }
        int i5 = exifInterface$SeekableByteOrderedDataInputStream.readInt();
        boolean z4 = DEBUG;
        if (z4) {
            Log.d(TAG, String.format("nextIfdOffset: %d", Integer.valueOf(i5)));
        }
        long j2 = i5;
        if (j2 <= 0) {
            if (z4) {
                a.n0("Stop reading file since a wrong offset may cause an infinite loop: ", i5, TAG);
            }
        } else {
            if (this.mAttributesOffsets.contains(Integer.valueOf(i5))) {
                if (z4) {
                    a.n0("Stop reading file since re-reading an IFD may cause an infinite loop: ", i5, TAG);
                    return;
                }
                return;
            }
            exifInterface$SeekableByteOrderedDataInputStream.seek(j2);
            if (this.mAttributes[4].isEmpty()) {
                readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, 4);
            } else if (this.mAttributes[5].isEmpty()) {
                readImageFileDirectory(exifInterface$SeekableByteOrderedDataInputStream, 5);
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void replaceInvalidTags(int i, String str, String str2) {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i].get(str) == null) {
            return;
        }
        HashMap[] mapArr = this.mAttributes;
        mapArr[i].put(str2, mapArr[i].get(str));
        this.mAttributes[i].remove(str);
    }

    private void retrieveJpegImageSize(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream, int i) throws Throwable {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        if (exifInterface$ExifAttribute == null || exifInterface$ExifAttribute2 == null) {
            ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifInterface$ExifAttribute exifInterface$ExifAttribute4 = this.mAttributes[i].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifInterface$ExifAttribute3 == null || exifInterface$ExifAttribute4 == null) {
                return;
            }
            int intValue = exifInterface$ExifAttribute3.getIntValue(this.mExifByteOrder);
            int intValue2 = exifInterface$ExifAttribute3.getIntValue(this.mExifByteOrder);
            exifInterface$SeekableByteOrderedDataInputStream.seek(intValue);
            byte[] bArr = new byte[intValue2];
            exifInterface$SeekableByteOrderedDataInputStream.read(bArr);
            getJpegAttributes(new ExifInterface$ByteOrderedDataInputStream(bArr), intValue, i);
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(inputStream);
        ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream = new ExifInterface$ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (exifInterface$ByteOrderedDataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        exifInterface$ByteOrderedDataOutputStream.writeByte(-1);
        if (exifInterface$ByteOrderedDataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        exifInterface$ByteOrderedDataOutputStream.writeByte(-40);
        ExifInterface$ExifAttribute exifInterface$ExifAttributeRemove = null;
        if (getAttribute(TAG_XMP) != null && this.mXmpIsFromSeparateMarker) {
            exifInterface$ExifAttributeRemove = this.mAttributes[0].remove(TAG_XMP);
        }
        exifInterface$ByteOrderedDataOutputStream.writeByte(-1);
        exifInterface$ByteOrderedDataOutputStream.writeByte(-31);
        writeExifSegment(exifInterface$ByteOrderedDataOutputStream);
        if (exifInterface$ExifAttributeRemove != null) {
            this.mAttributes[0].put(TAG_XMP, exifInterface$ExifAttributeRemove);
        }
        byte[] bArr = new byte[4096];
        while (exifInterface$ByteOrderedDataInputStream.readByte() == -1) {
            byte b2 = exifInterface$ByteOrderedDataInputStream.readByte();
            if (b2 == -39 || b2 == -38) {
                exifInterface$ByteOrderedDataOutputStream.writeByte(-1);
                exifInterface$ByteOrderedDataOutputStream.writeByte(b2);
                ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream);
                return;
            }
            if (b2 != -31) {
                exifInterface$ByteOrderedDataOutputStream.writeByte(-1);
                exifInterface$ByteOrderedDataOutputStream.writeByte(b2);
                int unsignedShort = exifInterface$ByteOrderedDataInputStream.readUnsignedShort();
                exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    throw new IOException("Invalid length");
                }
                while (i > 0) {
                    int i2 = exifInterface$ByteOrderedDataInputStream.read(bArr, 0, Math.min(i, 4096));
                    if (i2 < 0) {
                        break;
                    }
                    exifInterface$ByteOrderedDataOutputStream.write(bArr, 0, i2);
                    i -= i2;
                }
            } else {
                int unsignedShort2 = exifInterface$ByteOrderedDataInputStream.readUnsignedShort() - 2;
                if (unsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (unsignedShort2 >= 6) {
                    if (exifInterface$ByteOrderedDataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                        exifInterface$ByteOrderedDataInputStream.skipFully(unsignedShort2 - 6);
                    }
                }
                exifInterface$ByteOrderedDataOutputStream.writeByte(-1);
                exifInterface$ByteOrderedDataOutputStream.writeByte(b2);
                exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(unsignedShort2 + 2);
                if (unsignedShort2 >= 6) {
                    unsignedShort2 -= 6;
                    exifInterface$ByteOrderedDataOutputStream.write(bArr2);
                }
                while (unsignedShort2 > 0) {
                    int i3 = exifInterface$ByteOrderedDataInputStream.read(bArr, 0, Math.min(unsignedShort2, 4096));
                    if (i3 < 0) {
                        break;
                    }
                    exifInterface$ByteOrderedDataOutputStream.write(bArr, 0, i3);
                    unsignedShort2 -= i3;
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (DEBUG) {
            Log.d(TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream = new ExifInterface$ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, bArr.length);
        int i = this.mOffsetToExifData;
        if (i == 0) {
            int i2 = exifInterface$ByteOrderedDataInputStream.readInt();
            exifInterface$ByteOrderedDataOutputStream.writeInt(i2);
            ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, i2 + 4 + 4);
        } else {
            ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, ((i - bArr.length) - 4) - 4);
            exifInterface$ByteOrderedDataInputStream.skipFully(exifInterface$ByteOrderedDataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream2 = new ExifInterface$ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) exifInterface$ByteOrderedDataOutputStream2.mOutputStream).toByteArray();
                exifInterface$ByteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                exifInterface$ByteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x01ac A[Catch: all -> 0x01ee, Exception -> 0x01f1, TryCatch #4 {Exception -> 0x01f1, all -> 0x01ee, blocks: (B:7:0x004e, B:9:0x0057, B:63:0x01ce, B:10:0x0070, B:12:0x0078, B:14:0x0084, B:16:0x008c, B:18:0x0090, B:22:0x00a3, B:24:0x00ae, B:25:0x00b3, B:27:0x00c0, B:28:0x00c5, B:29:0x00c9, B:30:0x00d5, B:32:0x00dd, B:34:0x00e5, B:36:0x00ed, B:38:0x00f1, B:40:0x00fc, B:42:0x0107, B:44:0x010f, B:56:0x015a, B:58:0x01ac, B:62:0x01c8, B:59:0x01b8, B:61:0x01c0, B:45:0x011e, B:46:0x0125, B:47:0x0126, B:49:0x012e, B:51:0x0134, B:52:0x014d, B:53:0x0154, B:66:0x01e6, B:67:0x01ed), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01b8 A[Catch: all -> 0x01ee, Exception -> 0x01f1, TryCatch #4 {Exception -> 0x01f1, all -> 0x01ee, blocks: (B:7:0x004e, B:9:0x0057, B:63:0x01ce, B:10:0x0070, B:12:0x0078, B:14:0x0084, B:16:0x008c, B:18:0x0090, B:22:0x00a3, B:24:0x00ae, B:25:0x00b3, B:27:0x00c0, B:28:0x00c5, B:29:0x00c9, B:30:0x00d5, B:32:0x00dd, B:34:0x00e5, B:36:0x00ed, B:38:0x00f1, B:40:0x00fc, B:42:0x0107, B:44:0x010f, B:56:0x015a, B:58:0x01ac, B:62:0x01c8, B:59:0x01b8, B:61:0x01c0, B:45:0x011e, B:46:0x0125, B:47:0x0126, B:49:0x012e, B:51:0x0134, B:52:0x014d, B:53:0x0154, B:66:0x01e6, B:67:0x01ed), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01c0 A[Catch: all -> 0x01ee, Exception -> 0x01f1, TryCatch #4 {Exception -> 0x01f1, all -> 0x01ee, blocks: (B:7:0x004e, B:9:0x0057, B:63:0x01ce, B:10:0x0070, B:12:0x0078, B:14:0x0084, B:16:0x008c, B:18:0x0090, B:22:0x00a3, B:24:0x00ae, B:25:0x00b3, B:27:0x00c0, B:28:0x00c5, B:29:0x00c9, B:30:0x00d5, B:32:0x00dd, B:34:0x00e5, B:36:0x00ed, B:38:0x00f1, B:40:0x00fc, B:42:0x0107, B:44:0x010f, B:56:0x015a, B:58:0x01ac, B:62:0x01c8, B:59:0x01b8, B:61:0x01c0, B:45:0x011e, B:46:0x0125, B:47:0x0126, B:49:0x012e, B:51:0x0134, B:52:0x014d, B:53:0x0154, B:66:0x01e6, B:67:0x01ed), top: B:81:0x004e }] */
    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws Throwable {
        int i;
        int i2;
        int i3;
        int i4;
        if (DEBUG) {
            Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(inputStream, byteOrder);
        ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream = new ExifInterface$ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        exifInterface$ByteOrderedDataInputStream.skipFully(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream2 = new ExifInterface$ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                    int i5 = this.mOffsetToExifData;
                    if (i5 != 0) {
                        ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, ((i5 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                        exifInterface$ByteOrderedDataInputStream.skipFully(4);
                        exifInterface$ByteOrderedDataInputStream.skipFully(exifInterface$ByteOrderedDataInputStream.readInt());
                        writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (exifInterface$ByteOrderedDataInputStream.read(bArr3) != 4) {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                        byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                        boolean z2 = true;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int i6 = exifInterface$ByteOrderedDataInputStream.readInt();
                            byte[] bArr5 = new byte[i6 % 2 == 1 ? i6 + 1 : i6];
                            exifInterface$ByteOrderedDataInputStream.read(bArr5);
                            bArr5[0] = (byte) (8 | bArr5[0]);
                            if (((bArr5[0] >> 1) & 1) != 1) {
                                z2 = false;
                            }
                            exifInterface$ByteOrderedDataOutputStream2.write(bArr4);
                            exifInterface$ByteOrderedDataOutputStream2.writeInt(i6);
                            exifInterface$ByteOrderedDataOutputStream2.write(bArr5);
                            if (z2) {
                                copyChunksUpToGivenChunkType(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream.read(bArr6);
                                    if (!Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                        break;
                                    } else {
                                        copyWebPChunk(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, bArr6);
                                    }
                                }
                                writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                            } else {
                                copyChunksUpToGivenChunkType(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                            }
                        } else {
                            byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                int i7 = exifInterface$ByteOrderedDataInputStream.readInt();
                                int i8 = i7 % 2 == 1 ? i7 + 1 : i7;
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    exifInterface$ByteOrderedDataInputStream.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (exifInterface$ByteOrderedDataInputStream.read(bArr9) != 3 || !Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i = exifInterface$ByteOrderedDataInputStream.readInt();
                                    i2 = (i << 18) >> 18;
                                    i3 = (i << 2) >> 18;
                                    i8 -= 10;
                                } else {
                                    if (!Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                        i = 0;
                                        i2 = 0;
                                        i3 = 0;
                                    } else {
                                        if (exifInterface$ByteOrderedDataInputStream.readByte() != 47) {
                                            throw new IOException("Encountered error while checking VP8L signature");
                                        }
                                        i = exifInterface$ByteOrderedDataInputStream.readInt();
                                        i4 = i & 8;
                                        i8 -= 5;
                                        i3 = ((i << 4) >> 18) + 1;
                                        i2 = ((i << 18) >> 18) + 1;
                                    }
                                    exifInterface$ByteOrderedDataOutputStream2.write(bArr4);
                                    exifInterface$ByteOrderedDataOutputStream2.writeInt(10);
                                    byte[] bArr10 = new byte[10];
                                    bArr10[0] = (byte) (bArr10[0] | 8);
                                    bArr10[0] = (byte) (bArr10[0] | (i4 << 4));
                                    int i9 = i2 - 1;
                                    int i10 = i3 - 1;
                                    bArr10[4] = (byte) i9;
                                    bArr10[5] = (byte) (i9 >> 8);
                                    bArr10[6] = (byte) (i9 >> 16);
                                    bArr10[7] = (byte) i10;
                                    bArr10[8] = (byte) (i10 >> 8);
                                    bArr10[9] = (byte) (i10 >> 16);
                                    exifInterface$ByteOrderedDataOutputStream2.write(bArr10);
                                    exifInterface$ByteOrderedDataOutputStream2.write(bArr3);
                                    exifInterface$ByteOrderedDataOutputStream2.writeInt(i7);
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        exifInterface$ByteOrderedDataOutputStream2.write(bArr8);
                                        exifInterface$ByteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                        exifInterface$ByteOrderedDataOutputStream2.writeInt(i);
                                    } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                        exifInterface$ByteOrderedDataOutputStream2.write(47);
                                        exifInterface$ByteOrderedDataOutputStream2.writeInt(i);
                                    }
                                    ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, i8);
                                    writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                                }
                                i4 = 0;
                                exifInterface$ByteOrderedDataOutputStream2.write(bArr4);
                                exifInterface$ByteOrderedDataOutputStream2.writeInt(10);
                                byte[] bArr11 = new byte[10];
                                bArr11[0] = (byte) (bArr11[0] | 8);
                                bArr11[0] = (byte) (bArr11[0] | (i4 << 4));
                                int i11 = i2 - 1;
                                int i12 = i3 - 1;
                                bArr11[4] = (byte) i11;
                                bArr11[5] = (byte) (i11 >> 8);
                                bArr11[6] = (byte) (i11 >> 16);
                                bArr11[7] = (byte) i12;
                                bArr11[8] = (byte) (i12 >> 8);
                                bArr11[9] = (byte) (i12 >> 16);
                                exifInterface$ByteOrderedDataOutputStream2.write(bArr11);
                                exifInterface$ByteOrderedDataOutputStream2.write(bArr3);
                                exifInterface$ByteOrderedDataOutputStream2.writeInt(i7);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    exifInterface$ByteOrderedDataOutputStream2.write(bArr8);
                                    exifInterface$ByteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                    exifInterface$ByteOrderedDataOutputStream2.writeInt(i);
                                } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    exifInterface$ByteOrderedDataOutputStream2.write(47);
                                    exifInterface$ByteOrderedDataOutputStream2.writeInt(i);
                                }
                                ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2, i8);
                                writeExifSegment(exifInterface$ByteOrderedDataOutputStream2);
                            }
                        }
                    }
                    ExifInterfaceUtils.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream2);
                    int size = byteArrayOutputStream2.size();
                    byte[] bArr12 = WEBP_SIGNATURE_2;
                    exifInterface$ByteOrderedDataOutputStream.writeInt(size + bArr12.length);
                    exifInterface$ByteOrderedDataOutputStream.write(bArr12);
                    byteArrayOutputStream2.writeTo(exifInterface$ByteOrderedDataOutputStream);
                    ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                } catch (Exception e) {
                    e = e;
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void setThumbnailData(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) throws Throwable {
        HashMap<String, ExifInterface$ExifAttribute> map = this.mAttributes[4];
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = map.get(TAG_COMPRESSION);
        if (exifInterface$ExifAttribute == null) {
            this.mThumbnailCompression = 6;
            handleThumbnailFromJfif(exifInterface$ByteOrderedDataInputStream, map);
            return;
        }
        int intValue = exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                handleThumbnailFromJfif(exifInterface$ByteOrderedDataInputStream, map);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        if (isSupportedDataType(map)) {
            handleThumbnailFromStrips(exifInterface$ByteOrderedDataInputStream, map);
        }
    }

    private static boolean shouldSupportSeek(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    private void swapBasedOnImageSize(int i, int i2) throws Throwable {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i2].isEmpty()) {
            if (DEBUG) {
                Log.d(TAG, "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[i].get(TAG_IMAGE_LENGTH);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[i].get(TAG_IMAGE_WIDTH);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute4 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
        if (exifInterface$ExifAttribute == null || exifInterface$ExifAttribute2 == null) {
            if (DEBUG) {
                Log.d(TAG, "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifInterface$ExifAttribute3 == null || exifInterface$ExifAttribute4 == null) {
            if (DEBUG) {
                Log.d(TAG, "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int intValue = exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifInterface$ExifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifInterface$ExifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifInterface$ExifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, ExifInterface$ExifAttribute>[] mapArr = this.mAttributes;
        HashMap<String, ExifInterface$ExifAttribute> map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    private void updateImageSizeValues(ExifInterface$SeekableByteOrderedDataInputStream exifInterface$SeekableByteOrderedDataInputStream, int i) throws Throwable {
        ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort;
        ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort2;
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[i].get(TAG_DEFAULT_CROP_SIZE);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute3 = this.mAttributes[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute4 = this.mAttributes[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute5 = this.mAttributes[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifInterface$ExifAttribute == null) {
            if (exifInterface$ExifAttribute2 == null || exifInterface$ExifAttribute3 == null || exifInterface$ExifAttribute4 == null || exifInterface$ExifAttribute5 == null) {
                retrieveJpegImageSize(exifInterface$SeekableByteOrderedDataInputStream, i);
                return;
            }
            int intValue = exifInterface$ExifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifInterface$ExifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifInterface$ExifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifInterface$ExifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort3 = ExifInterface$ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            ExifInterface$ExifAttribute exifInterface$ExifAttributeCreateUShort4 = ExifInterface$ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            this.mAttributes[i].put(TAG_IMAGE_LENGTH, exifInterface$ExifAttributeCreateUShort3);
            this.mAttributes[i].put(TAG_IMAGE_WIDTH, exifInterface$ExifAttributeCreateUShort4);
            return;
        }
        if (exifInterface$ExifAttribute.format == 5) {
            ExifInterface$Rational[] exifInterface$RationalArr = (ExifInterface$Rational[]) exifInterface$ExifAttribute.getValue(this.mExifByteOrder);
            if (exifInterface$RationalArr == null || exifInterface$RationalArr.length != 2) {
                StringBuilder sbU = a.U("Invalid crop size values. cropSize=");
                sbU.append(Arrays.toString(exifInterface$RationalArr));
                Log.w(TAG, sbU.toString());
                return;
            }
            exifInterface$ExifAttributeCreateUShort = ExifInterface$ExifAttribute.createURational(exifInterface$RationalArr[0], this.mExifByteOrder);
            exifInterface$ExifAttributeCreateUShort2 = ExifInterface$ExifAttribute.createURational(exifInterface$RationalArr[1], this.mExifByteOrder);
        } else {
            int[] iArr = (int[]) exifInterface$ExifAttribute.getValue(this.mExifByteOrder);
            if (iArr == null || iArr.length != 2) {
                StringBuilder sbU2 = a.U("Invalid crop size values. cropSize=");
                sbU2.append(Arrays.toString(iArr));
                Log.w(TAG, sbU2.toString());
                return;
            }
            exifInterface$ExifAttributeCreateUShort = ExifInterface$ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
            exifInterface$ExifAttributeCreateUShort2 = ExifInterface$ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
        }
        this.mAttributes[i].put(TAG_IMAGE_WIDTH, exifInterface$ExifAttributeCreateUShort);
        this.mAttributes[i].put(TAG_IMAGE_LENGTH, exifInterface$ExifAttributeCreateUShort2);
    }

    private void validateImages() throws Throwable {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (exifInterface$ExifAttribute != null && exifInterface$ExifAttribute2 != null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifInterface$ExifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifInterface$ExifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifInterface$ExifAttribute>[] mapArr = this.mAttributes;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private int writeExifSegment(ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream) throws IOException {
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifInterface$ExifTagArr.length];
        int[] iArr2 = new int[exifInterface$ExifTagArr.length];
        for (ExifInterface$ExifTag exifInterface$ExifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifInterface$ExifTag.name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute(TAG_STRIP_OFFSETS);
                removeAttribute(TAG_STRIP_BYTE_COUNTS);
            } else {
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            for (Object obj : this.mAttributes[i].entrySet().toArray()) {
                Map$Entry map$Entry = (Map$Entry) obj;
                if (map$Entry.getValue() == null) {
                    this.mAttributes[i].remove(map$Entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifInterface$ExifAttribute.createUShort(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, ExifInterface$ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface$ExifAttribute.createULong(0L, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface$ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            Iterator<Map$Entry<String, ExifInterface$ExifAttribute>> it = this.mAttributes[i2].entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int size = it.next().getValue().size();
                if (size > 4) {
                    i3 += size;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int size2 = 8;
        for (int i4 = 0; i4 < EXIF_TAGS.length; i4++) {
            if (!this.mAttributes[i4].isEmpty()) {
                iArr[i4] = size2;
                size2 = (this.mAttributes[i4].size() * 12) + 2 + 4 + iArr2[i4] + size2;
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifInterface$ExifAttribute.createUShort(size2, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface$ExifAttribute.createULong(size2, this.mExifByteOrder));
            }
            this.mThumbnailOffset = size2;
            size2 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            size2 += 8;
        }
        if (DEBUG) {
            for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
                Log.d(TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i5), Integer.valueOf(iArr[i5]), Integer.valueOf(this.mAttributes[i5].size()), Integer.valueOf(iArr2[i5]), Integer.valueOf(size2)));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifInterface$ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifInterface$ExifAttribute.createULong(iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifInterface$ExifAttribute.createULong(iArr[3], this.mExifByteOrder));
        }
        int i6 = this.mMimeType;
        if (i6 == 4) {
            exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(size2);
            exifInterface$ByteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        } else if (i6 == 13) {
            exifInterface$ByteOrderedDataOutputStream.writeInt(size2);
            exifInterface$ByteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i6 == 14) {
            exifInterface$ByteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
            exifInterface$ByteOrderedDataOutputStream.writeInt(size2);
        }
        exifInterface$ByteOrderedDataOutputStream.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        exifInterface$ByteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(42);
        exifInterface$ByteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i7 = 0; i7 < EXIF_TAGS.length; i7++) {
            if (!this.mAttributes[i7].isEmpty()) {
                exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i7].size());
                int size3 = (this.mAttributes[i7].size() * 12) + iArr[i7] + 2 + 4;
                for (Map$Entry<String, ExifInterface$ExifAttribute> map$Entry2 : this.mAttributes[i7].entrySet()) {
                    int i8 = sExifTagMapsForWriting[i7].get(map$Entry2.getKey()).number;
                    ExifInterface$ExifAttribute value = map$Entry2.getValue();
                    int size4 = value.size();
                    exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(i8);
                    exifInterface$ByteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    exifInterface$ByteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size4 > 4) {
                        exifInterface$ByteOrderedDataOutputStream.writeUnsignedInt(size3);
                        size3 += size4;
                    } else {
                        exifInterface$ByteOrderedDataOutputStream.write(value.bytes);
                        if (size4 < 4) {
                            while (size4 < 4) {
                                exifInterface$ByteOrderedDataOutputStream.writeByte(0);
                                size4++;
                            }
                        }
                    }
                }
                if (i7 != 0 || this.mAttributes[4].isEmpty()) {
                    exifInterface$ByteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    exifInterface$ByteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                }
                Iterator<Map$Entry<String, ExifInterface$ExifAttribute>> it2 = this.mAttributes[i7].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().bytes;
                    if (bArr.length > 4) {
                        exifInterface$ByteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            exifInterface$ByteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && size2 % 2 == 1) {
            exifInterface$ByteOrderedDataOutputStream.writeByte(0);
        }
        exifInterface$ByteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return size2;
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        return attributeDouble * ((double) (attributeInt != 1 ? 1 : -1));
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        ExifInterface$ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i = exifAttribute.format;
                if (i != 5 && i != 10) {
                    StringBuilder sbU = a.U("GPS Timestamp format is not rational. format=");
                    sbU.append(exifAttribute.format);
                    Log.w(TAG, sbU.toString());
                    return null;
                }
                ExifInterface$Rational[] exifInterface$RationalArr = (ExifInterface$Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (exifInterface$RationalArr != null && exifInterface$RationalArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (exifInterface$RationalArr[0].numerator / exifInterface$RationalArr[0].denominator)), Integer.valueOf((int) (exifInterface$RationalArr[1].numerator / exifInterface$RationalArr[1].denominator)), Integer.valueOf((int) (exifInterface$RationalArr[2].numerator / exifInterface$RationalArr[2].denominator)));
                }
                StringBuilder sbU2 = a.U("Invalid GPS Timestamp array. array=");
                sbU2.append(Arrays.toString(exifInterface$RationalArr));
                Log.w(TAG, sbU2.toString());
                return null;
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        ExifInterface$ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return exifAttribute.bytes;
        }
        return null;
    }

    public double getAttributeDouble(@NonNull String str, double d) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        ExifInterface$ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return d;
        }
        try {
            return exifAttribute.getDoubleValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public int getAttributeInt(@NonNull String str, int i) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        ExifInterface$ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        ExifInterface$ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return new long[]{exifAttribute.bytesOffset, exifAttribute.bytes.length};
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @Nullable
    @SuppressLint({"AutoBoxing"})
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (attribute != null && attribute2 != null) {
            Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String str = attribute + ' ' + attribute2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date date = sFormatterPrimary.parse(str, parsePosition);
                    if (date == null && (date = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(date.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() throws Throwable {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + 0 + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            ExifInterface$ExifAttribute exifInterface$ExifAttribute = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
            ExifInterface$ExifAttribute exifInterface$ExifAttribute2 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
            if (exifInterface$ExifAttribute != null && exifInterface$ExifAttribute2 != null) {
                return Bitmap.createBitmap(iArr, exifInterface$ExifAttribute2.getIntValue(this.mExifByteOrder), exifInterface$ExifAttribute.getIntValue(this.mExifByteOrder), Bitmap$Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Nullable
    public byte[] getThumbnailBytes() throws Throwable {
        FileDescriptor fileDescriptor;
        ?? r1;
        Exception e;
        FileDescriptor fileDescriptor2;
        ?? fileInputStream;
        ?? fileInputStream2;
        ?? r2 = 0;
        r2 = 0;
        if (!this.mHasThumbnail) {
            return null;
        }
        ?? r3 = this.mThumbnailBytes;
        try {
            if (r3 != 0) {
                return r3;
            }
            try {
                r3 = this.mAssetInputStream;
                if (r3 != 0) {
                    try {
                        if (!r3.markSupported()) {
                            Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");
                            ExifInterfaceUtils.closeQuietly(r3);
                            return null;
                        }
                        r3.reset();
                        fileInputStream2 = r3;
                        fileDescriptor2 = null;
                        fileInputStream = fileInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileDescriptor2 = null;
                        r1 = r3;
                        Log.d(TAG, "Encountered exception while getting thumbnail", e);
                        ExifInterfaceUtils.closeQuietly(r1);
                        if (fileDescriptor2 != null) {
                            ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileDescriptor = null;
                        r2 = r3;
                        ExifInterfaceUtils.closeQuietly(r2);
                        if (fileDescriptor != null) {
                            ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                } else if (this.mFilename != null) {
                    fileInputStream2 = new FileInputStream(this.mFilename);
                    fileDescriptor2 = null;
                    fileInputStream = fileInputStream2;
                } else {
                    FileDescriptor fileDescriptorDup = ExifInterfaceUtils$Api21Impl.dup(this.mSeekableFileDescriptor);
                    try {
                        ExifInterfaceUtils$Api21Impl.lseek(fileDescriptorDup, 0L, OsConstants.SEEK_SET);
                        fileDescriptor2 = fileDescriptorDup;
                        fileInputStream = new FileInputStream(fileDescriptorDup);
                    } catch (Exception e3) {
                        e = e3;
                        fileDescriptor2 = fileDescriptorDup;
                        r1 = 0;
                        Log.d(TAG, "Encountered exception while getting thumbnail", e);
                        ExifInterfaceUtils.closeQuietly(r1);
                        if (fileDescriptor2 != null) {
                            ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileDescriptor = fileDescriptorDup;
                        ExifInterfaceUtils.closeQuietly(r2);
                        if (fileDescriptor != null) {
                            ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                }
                try {
                    if (fileInputStream == 0) {
                        throw new FileNotFoundException();
                    }
                    if (fileInputStream.skip(this.mThumbnailOffset + this.mOffsetToExifData) != this.mThumbnailOffset + this.mOffsetToExifData) {
                        throw new IOException("Corrupted image");
                    }
                    byte[] bArr = new byte[this.mThumbnailLength];
                    if (fileInputStream.read(bArr) != this.mThumbnailLength) {
                        throw new IOException("Corrupted image");
                    }
                    this.mThumbnailBytes = bArr;
                    ExifInterfaceUtils.closeQuietly(fileInputStream);
                    if (fileDescriptor2 != null) {
                        ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                    }
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                    r1 = fileInputStream;
                    Log.d(TAG, "Encountered exception while getting thumbnail", e);
                    ExifInterfaceUtils.closeQuietly(r1);
                    if (fileDescriptor2 != null) {
                        ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                    }
                    return null;
                }
            } catch (Exception e5) {
                r1 = 0;
                e = e5;
                fileDescriptor2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        if (!this.mHasThumbnail) {
            return null;
        }
        if (!this.mHasThumbnailStrips || this.mAreThumbnailStripsConsecutive) {
            return new long[]{this.mThumbnailOffset + this.mOffsetToExifData, this.mThumbnailLength};
        }
        return null;
    }

    public boolean hasAttribute(@NonNull String str) {
        return getExifAttribute(str) != null;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 != 0) {
            throw new IllegalArgumentException("degree should be a multiple of 90");
        }
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        List<Integer> list = ROTATION_ORDER;
        int iIntValue = 0;
        if (list.contains(Integer.valueOf(attributeInt))) {
            int iIndexOf = ((i / 90) + list.indexOf(Integer.valueOf(attributeInt))) % 4;
            iIntValue = list.get(iIndexOf + (iIndexOf < 0 ? 4 : 0)).intValue();
        } else {
            List<Integer> list2 = FLIPPED_ROTATION_ORDER;
            if (list2.contains(Integer.valueOf(attributeInt))) {
                int iIndexOf2 = ((i / 90) + list2.indexOf(Integer.valueOf(attributeInt))) % 4;
                iIntValue = list2.get(iIndexOf2 + (iIndexOf2 < 0 ? 4 : 0)).intValue();
            }
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(iIntValue));
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00f6 A[Catch: all -> 0x011e, Exception -> 0x0121, TryCatch #15 {Exception -> 0x0121, all -> 0x011e, blocks: (B:66:0x00f2, B:68:0x00f6, B:70:0x010c, B:69:0x0105), top: B:134:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0105 A[Catch: all -> 0x011e, Exception -> 0x0121, TryCatch #15 {Exception -> 0x0121, all -> 0x011e, blocks: (B:66:0x00f2, B:68:0x00f6, B:70:0x010c, B:69:0x0105), top: B:134:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0158  */
    public void saveAttributes() throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        Exception exc;
        FileOutputStream fileOutputStream3;
        InputStream fileInputStream2;
        Exception e;
        FileOutputStream fileOutputStream4;
        if (!isSupportedFormatForSavingAttributes(this.mMimeType)) {
            throw new IOException("ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats.");
        }
        if (this.mSeekableFileDescriptor == null && this.mFilename == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        if (this.mHasThumbnail && this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
            throw new IOException("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
        }
        this.mModified = true;
        this.mThumbnailBytes = getThumbnail();
        InputStream inputStream = null;
        try {
            File fileCreateTempFile = File.createTempFile("temp", "tmp");
            if (this.mFilename != null) {
                fileInputStream = new FileInputStream(this.mFilename);
            } else {
                ExifInterfaceUtils$Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(this.mSeekableFileDescriptor);
            }
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    ExifInterfaceUtils.copy(fileInputStream, fileOutputStream);
                    ExifInterfaceUtils.closeQuietly(fileInputStream);
                    ExifInterfaceUtils.closeQuietly(fileOutputStream);
                    try {
                        try {
                            try {
                                FileInputStream fileInputStream3 = new FileInputStream(fileCreateTempFile);
                                try {
                                    if (this.mFilename != null) {
                                        fileOutputStream3 = new FileOutputStream(this.mFilename);
                                    } else {
                                        ExifInterfaceUtils$Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream3 = new FileOutputStream(this.mSeekableFileDescriptor);
                                    }
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream3);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream3);
                                            try {
                                                int i = this.mMimeType;
                                                if (i == 4) {
                                                    saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 13) {
                                                    savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 14) {
                                                    saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 3 || i == 0) {
                                                    writeExifSegment(new ExifInterface$ByteOrderedDataOutputStream(bufferedOutputStream, ByteOrder.BIG_ENDIAN));
                                                }
                                                ExifInterfaceUtils.closeQuietly(bufferedInputStream);
                                                ExifInterfaceUtils.closeQuietly(bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                this.mThumbnailBytes = null;
                                            } catch (Exception e2) {
                                                exc = e2;
                                                inputStream = fileInputStream3;
                                                try {
                                                    fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                                    try {
                                                        if (this.mFilename == null) {
                                                            ExifInterfaceUtils$Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                                            fileOutputStream4 = new FileOutputStream(this.mSeekableFileDescriptor);
                                                        } else {
                                                            fileOutputStream4 = new FileOutputStream(this.mFilename);
                                                        }
                                                        fileOutputStream3 = fileOutputStream4;
                                                        ExifInterfaceUtils.copy(fileInputStream2, fileOutputStream3);
                                                        ExifInterfaceUtils.closeQuietly(fileInputStream2);
                                                        ExifInterfaceUtils.closeQuietly(fileOutputStream3);
                                                        throw new IOException("Failed to save new file", exc);
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        try {
                                                            throw new IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            inputStream = fileInputStream2;
                                                            ExifInterfaceUtils.closeQuietly(inputStream);
                                                            ExifInterfaceUtils.closeQuietly(fileOutputStream3);
                                                            throw th;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        inputStream = fileInputStream2;
                                                        ExifInterfaceUtils.closeQuietly(inputStream);
                                                        ExifInterfaceUtils.closeQuietly(fileOutputStream3);
                                                        throw th;
                                                    }
                                                } catch (Exception e4) {
                                                    fileInputStream2 = inputStream;
                                                    e = e4;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            inputStream = fileInputStream3;
                                            exc = e5;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            inputStream = bufferedInputStream;
                                            ExifInterfaceUtils.closeQuietly(inputStream);
                                            ExifInterfaceUtils.closeQuietly(0);
                                            if (0 == 0) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e6) {
                                        inputStream = fileInputStream3;
                                        exc = e6;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    fileOutputStream2 = null;
                                    inputStream = fileInputStream3;
                                    exc = e;
                                    fileOutputStream3 = fileOutputStream2;
                                    fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                    if (this.mFilename == null) {
                                        ExifInterfaceUtils$Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream4 = new FileOutputStream(this.mSeekableFileDescriptor);
                                    } else {
                                        fileOutputStream4 = new FileOutputStream(this.mFilename);
                                    }
                                    fileOutputStream3 = fileOutputStream4;
                                    ExifInterfaceUtils.copy(fileInputStream2, fileOutputStream3);
                                    ExifInterfaceUtils.closeQuietly(fileInputStream2);
                                    ExifInterfaceUtils.closeQuietly(fileOutputStream3);
                                    throw new IOException("Failed to save new file", exc);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                ExifInterfaceUtils.closeQuietly(inputStream);
                                ExifInterfaceUtils.closeQuietly(0);
                                if (0 == 0) {
                                    fileCreateTempFile.delete();
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            fileOutputStream2 = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e9) {
                    e = e9;
                    inputStream = fileInputStream;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th7) {
                        th = th7;
                        ExifInterfaceUtils.closeQuietly(inputStream);
                        ExifInterfaceUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = fileInputStream;
                    ExifInterfaceUtils.closeQuietly(inputStream);
                    ExifInterfaceUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            fileOutputStream = null;
        }
    }

    public void setAltitude(double d) {
        String str = d >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new ExifInterface$Rational(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifInterface$ExifTag exifInterface$ExifTag;
        int i;
        String string;
        String str3 = str;
        String strReplaceAll = str2;
        Objects.requireNonNull(str3, "tag shouldn't be null");
        if ((TAG_DATETIME.equals(str3) || TAG_DATETIME_ORIGINAL.equals(str3) || TAG_DATETIME_DIGITIZED.equals(str3)) && strReplaceAll != null) {
            boolean zFind = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
            boolean zFind2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", ":");
            }
        }
        if (TAG_ISO_SPEED_RATINGS.equals(str3)) {
            if (DEBUG) {
                Log.d(TAG, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i2 = 2;
        int i3 = 1;
        if (strReplaceAll != null && sTagSetForCompatibility.contains(str3)) {
            if (str3.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = GPS_TIMESTAMP_PATTERN.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new ExifInterface$Rational(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        char c = 0;
        int i4 = 0;
        while (i4 < EXIF_TAGS.length) {
            if ((i4 != 4 || this.mHasThumbnail) && (exifInterface$ExifTag = sExifTagMapsForWriting[i4].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair<Integer, Integer> pairGuessDataFormat = guessDataFormat(strReplaceAll);
                    int i5 = -1;
                    if (exifInterface$ExifTag.primaryFormat == ((Integer) pairGuessDataFormat.first).intValue() || exifInterface$ExifTag.primaryFormat == ((Integer) pairGuessDataFormat.second).intValue()) {
                        i = exifInterface$ExifTag.primaryFormat;
                    } else {
                        int i6 = exifInterface$ExifTag.secondaryFormat;
                        if (i6 == -1 || !(i6 == ((Integer) pairGuessDataFormat.first).intValue() || exifInterface$ExifTag.secondaryFormat == ((Integer) pairGuessDataFormat.second).intValue())) {
                            int i7 = exifInterface$ExifTag.primaryFormat;
                            if (i7 == i3 || i7 == 7 || i7 == i2) {
                                i = i7;
                            } else if (DEBUG) {
                                StringBuilder sbY = a.Y("Given tag (", str3, ") value didn't match with one of expected formats: ");
                                String[] strArr = IFD_FORMAT_NAMES;
                                sbY.append(strArr[exifInterface$ExifTag.primaryFormat]);
                                String string2 = "";
                                if (exifInterface$ExifTag.secondaryFormat == -1) {
                                    string = "";
                                } else {
                                    StringBuilder sbU = a.U(", ");
                                    sbU.append(strArr[exifInterface$ExifTag.secondaryFormat]);
                                    string = sbU.toString();
                                }
                                sbY.append(string);
                                sbY.append(" (guess: ");
                                sbY.append(strArr[((Integer) pairGuessDataFormat.first).intValue()]);
                                if (((Integer) pairGuessDataFormat.second).intValue() != -1) {
                                    StringBuilder sbU2 = a.U(", ");
                                    sbU2.append(strArr[((Integer) pairGuessDataFormat.second).intValue()]);
                                    string2 = sbU2.toString();
                                }
                                sbY.append(string2);
                                sbY.append(")");
                                Log.d(TAG, sbY.toString());
                            }
                        } else {
                            i = exifInterface$ExifTag.secondaryFormat;
                        }
                    }
                    switch (i) {
                        case 1:
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createByte(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createString(strReplaceAll));
                            break;
                        case 3:
                            String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i8 = 0; i8 < strArrSplit.length; i8++) {
                                iArr[i8] = Integer.parseInt(strArrSplit[i8]);
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                            break;
                        case 4:
                            String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i9 = 0; i9 < strArrSplit2.length; i9++) {
                                jArr[i9] = Long.parseLong(strArrSplit2[i9]);
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createULong(jArr, this.mExifByteOrder));
                            break;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            ExifInterface$Rational[] exifInterface$RationalArr = new ExifInterface$Rational[strArrSplit3.length];
                            int i10 = 0;
                            while (i10 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i10].split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, i5);
                                exifInterface$RationalArr[i10] = new ExifInterface$Rational((long) Double.parseDouble(strArrSplit4[0]), (long) Double.parseDouble(strArrSplit4[1]));
                                i10++;
                                i5 = -1;
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createURational(exifInterface$RationalArr, this.mExifByteOrder));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (DEBUG) {
                                a.n0("Data format isn't one of expected formats: ", i, TAG);
                            }
                            break;
                        case 9:
                            String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i11 = 0; i11 < strArrSplit5.length; i11++) {
                                iArr2[i11] = Integer.parseInt(strArrSplit5[i11]);
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            ExifInterface$Rational[] exifInterface$RationalArr2 = new ExifInterface$Rational[strArrSplit6.length];
                            int i12 = 0;
                            while (i12 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i12].split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, -1);
                                exifInterface$RationalArr2[i12] = new ExifInterface$Rational((long) Double.parseDouble(strArrSplit7[c]), (long) Double.parseDouble(strArrSplit7[i3]));
                                i12++;
                                c = 0;
                                i3 = 1;
                                strArrSplit6 = strArrSplit6;
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createSRational(exifInterface$RationalArr2, this.mExifByteOrder));
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i13 = 0; i13 < strArrSplit8.length; i13++) {
                                dArr[i13] = Double.parseDouble(strArrSplit8[i13]);
                            }
                            this.mAttributes[i4].put(str3, ExifInterface$ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                            break;
                    }
                } else {
                    this.mAttributes[i4].remove(str3);
                }
            }
            i4++;
            i2 = 2;
            c = 0;
            i3 = 1;
        }
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void setDateTime(@NonNull Long l) {
        Objects.requireNonNull(l, "Timestamp should not be null.");
        if (l.longValue() < 0) {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
        String string = Long.toString(l.longValue() % 1000);
        for (int length = string.length(); length < 3; length++) {
            string = a.w("0", string);
        }
        setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(l.longValue())));
        setAttribute(TAG_SUBSEC_TIME, string);
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new ExifInterface$Rational((location.getSpeed() * TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        String[] strArrSplit = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, strArrSplit[0]);
        setAttribute(TAG_GPS_TIMESTAMP, strArrSplit[1]);
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        }
        if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        }
        setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
        setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
        setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
        setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            StringBuilder sbU = a.U("Latitude/longitude values are not parsable. ");
            sbU.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            Log.w(TAG, sbU.toString());
            return null;
        }
    }

    public ExifInterface(@NonNull String str) throws Throwable {
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifInterface$ExifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifInterface$ExifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        initForFilename(str);
    }

    public ExifInterface(@NonNull FileDescriptor fileDescriptor) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifInterface$ExifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifInterface$ExifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(fileDescriptor, "fileDescriptor cannot be null");
        this.mAssetInputStream = null;
        this.mFilename = null;
        boolean z2 = false;
        if (isSeekableFD(fileDescriptor)) {
            this.mSeekableFileDescriptor = fileDescriptor;
            try {
                fileDescriptor = ExifInterfaceUtils$Api21Impl.dup(fileDescriptor);
                z2 = true;
            } catch (Exception e) {
                throw new IOException("Failed to duplicate file descriptor", e);
            }
        } else {
            this.mSeekableFileDescriptor = null;
        }
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
            try {
                loadAttributes(fileInputStream);
                ExifInterfaceUtils.closeQuietly(fileInputStream);
                if (z2) {
                    ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                }
            } catch (Throwable th2) {
                th = th2;
                ExifInterfaceUtils.closeQuietly(fileInputStream);
                if (z2) {
                    ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006a  */
    public ExifInterface(@NonNull InputStream inputStream, int i) throws IOException {
        ExifInterface$ExifTag[][] exifInterface$ExifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifInterface$ExifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifInterface$ExifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.mFilename = null;
        if (i == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
            if (!isExifDataOnly(bufferedInputStream)) {
                Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.mIsExifDataOnly = true;
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager$AssetInputStream) {
            this.mAssetInputStream = (AssetManager$AssetInputStream) inputStream;
            this.mSeekableFileDescriptor = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            if (isSeekableFD(fileInputStream.getFD())) {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = fileInputStream.getFD();
            } else {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
        } else {
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        }
        loadAttributes(inputStream);
    }
}
