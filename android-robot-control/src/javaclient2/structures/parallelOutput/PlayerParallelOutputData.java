package javaclient2.structures.parallelOutput;
/**************************************************************************
* PlayerServoData es la estructura de datos utilizada por ServoInterface
* 
* �sta clase fue escrita para la TESIS de Ingenier�a en Inform�tica de la
* Facultad Argentina de la Empresa (UADE).
**************************************************************************/

import javaclient2.structures.*;

public class PlayerParallelOutputData implements PlayerConstants {
	
	//Posiciones actuales de los servos inicializado a la mitad.
	private boolean[] ActualParallelData = { false, false, false, false, false, false, false, false };
	
	//TODO: M�todos para setear los valores del puerto paralelo.
	
	/***************************************************************************
	 * getBit devuelve la posicion de un servo en particular del 0 al 7
	 * 
	 * @param bit = n�mero de servo del 0 al 7
	 ***************************************************************************/
	public synchronized boolean getBit (int salida) {
		if ((salida<=7)&(salida>=0))
			return this.ActualParallelData[salida];
		return false;
    }
	
	/***************************************************************************
	 * getBit devuelve la posicion de una salida en particular del 0 al 7
	 * 
	 * @param Bit = n�mero de servo del 0 al 7
	 * @param salida = true o false
	 ***************************************************************************/
	public synchronized boolean setBit (int bit, boolean salida) {
		if ((bit<=7)&(bit>=0))
		{
			this.ActualParallelData[bit] = salida;
			return true;
		}
		else
			System.err.println ("     [ PlayerServoData ERROR: setBit(" + bit + ", " + salida + ")  -> Must be servo in 0-7 and angle in true or false    ]" );
		return false;
    }
	
	/***************************************************************************
	 * getServo devuelve el array de posiciones de los 8 servos
	 * 
	 ***************************************************************************/
	public synchronized boolean[] getParallelArray () {
		return this.ActualParallelData;
    }

	/***************************************************************************
	 * getServo devuelve el array de posiciones de los 8 servos
	 * 
	 * @param servoArray = Array de 8 posiciones con los valores de cada servo
	 ***************************************************************************/
	public synchronized boolean setParallelArray (boolean[] ParallelArray) {
		// Chequear que tenga 7 bits
		if (ParallelArray.length==8)
		{
		//Grabar el array de int[]
			ActualParallelData = ParallelArray;
			return true;
		} else
		{
			return false;
		}
	}

}
