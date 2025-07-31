package geradorpdf.construirpdf;

import com.itextpdf.kernel.color.DeviceRgb;

public class ItextUtilsPdf {
	public static DeviceRgb converteHex(String valorHex) {
		return new DeviceRgb(Integer.valueOf(valorHex.substring(0, 2), 16), Integer.valueOf(valorHex.substring(2, 4), 16), Integer.valueOf(valorHex.substring(4, 6), 16));
	}
	
}
