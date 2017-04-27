//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;

public class FormFigure extends SlotMachine
{
	private int[] key;
	private static String[] top = new String[3];
	private static String[] mid = new String[3];
	private static String[] bot = new String[3];

	//Pictures
	{

	//<--------------------------------MUSHROOM PICTURE--------------------------->
		top[0] = "                     . $MMMMMMMMMMMD..                      \n"
				+ "                   DMMMMM...     ,MMMMMM.                   \n"
				+ "                :MMMMM .           ..MMMMMI                 \n"
				+ "              IMMMMM.                . MMMMMM               \n"
				+ "            .MMMMMM                    .MMMMMM$             \n"
				+ "          .MMMMMMM                      .MMMMMMM.           \n"
				+ "         .MMMMMMM:                       .MMMMMMM.          \n"
				+ "       ..MMMMMMMM                         MMMMMMMMM.        \n"
				+ "       .MMMMMMMMM.                        MMMMMMMM+8        \n"
				+ "       M MMMMMMMM                         MMMMMMMM DZ       \n"
				+ "      M  MMMMMMMM                         MMMMMMMM .M.      \n"
				+ "     M   MMMMMMMM.                       .MMMMMMMM  .M      \n";

		mid[0] = "     M   MMMMMMMMM.                     .MMMMMMMMM   .M     \n"
				+ "   .M.   MMMMMMMMMM                     MMMMMMMMMM    M.    \n"
				+ "   .M    MMMMMMMMMMM                  .MMMMMMMMMMM.   ,7    \n"
				+ "  .M.    MMMMMMMMMMMMM..             MMMMMMMMMMMMMM   .M    \n"
				+ "   M    NMMMMMMMMMMMMMMM~.        ~MMMMMMMMMMMMMMMM.   M    \n"
				+ "   M   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMO  .M    \n"
				+ "  .M   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .M    \n"
				+ "   M  MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM, M    \n"
				+ "   M.MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM    \n"
				+ "    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     \n"
				+ "   .8MMMMMMMMMMMMMMMM$.           .  MMMMMMMMMMMMMMMMM,     \n"
				+ "     MMMMMMMMMMMM+     MM.       .MM    .MMMMMMMMMMMMM      \n";

		bot[0] = "      7MMMMMMMM        M.:        M ,      ,MMMMMMMMI       \n"
				+ "        MMMMMM.        M D       .M 8        MMMMMM.        \n"
				+ "         .MMMM         MM8       .MM$        MMMM.          \n"
				+ "           ..M.        MM        .MM.        M+.            \n"
				+ "             ,M        MM.       .MM.       .M              \n"
				+ "              M                             M..             \n"
				+ "              .M~                         .MN.              \n"
				+ "                OM:.                    .NM,                \n"
				+ "                  .MMMD ..         ..$MMM..                 \n"
				+ "                        .$MMMMMMMMM,.\n";

		//<----------------------------FLOWER PICTURE---------------------------->
		top[1] = "                       7777777777?                          \n"
				+ "                 :777777777777777777777                     \n"
				+ "              I77777$$$$$$$$$$$$$$$$777777                  \n"
				+ "            77777$$$$$$+++++++++++$$$$$$7777=               \n"
				+ "          77777$$$$++++???????????++++$$$$7777              \n"
				+ "         7777$$$+++????I?+=~~~=+II???+++$$$77777            \n"
				+ "        7777$$$++???I=~:,.     .,:~+I??+++$$$7777           \n"
				+ "       7777$$+++??I=:,             ,~+I??++$$$7777          \n"
				+ "      7777$$$++??I~:   DD      DD   .:=I??++$$7777          \n"
				+ "      7777$$++??I=:    ZO      O$    .:+I?++I$$777=         \n"
				+ "      7777$$++??I~,    DD      DD     :=I??++$$7777         \n"
				+ "      7777$$++??I~,    DD      DD     :=I??++$$7777         \n"
				+ "      7777$$+++?I=:.   DD      DD    ,~???++$$7777          \n";

		mid[1] = "       777$$$++??I=:.               ,~?I?+++$$7777          \n"
				+ "       7777$$$++????~,.           ,:=I??+++$$7777           \n"
				+ "        7777$$$+++????=~:,....,,:~+I???++$$$7777            \n"
				+ "          7777$$$++++????II???II????+++$$$77777             \n"
				+ "           77777$$$$++++++????++++++$$$$77777I              \n"
				+ "             777777$$$$$$$$II7$$$$$$$777777=                \n"
				+ "                77777777$$$$$$$$777777777                   \n"
				+ "                    77777777777777777                       \n"
				+ "                          ZZZZZ                             \n"
				+ "                          ZZZZZ                             \n"
				+ "                          $ZZZZ                             \n"
				+ "                          $$$$Z                             \n";

		bot[1] = "      I$ZZZZZZZ$          $$$$$         ZZZZZZZZZ$7II       \n"
				+ "     II$$ZZZZZZZZZZ       $$$$$       ZZZZZZZZZZ$$7II~      \n"
				+ "     II7$$$ZZZZZZZ$$      $$$$$     $$$$ZZZZZZ$$$77II?      \n"
				+ "     II77$$$$$$$$$$$$$    7777$    $$$$$$$$$$$$$77III       \n"
				+ "      II777$$$$$$$$$$$$   77777  7$$$$$$$$$$$$$777III       \n"
				+ "      III77777$$$$$$77777 77777 77777$$$$$$$77777III        \n"
				+ "       IIII777777777777777777777777777777777777IIIII        \n"
				+ "        IIIII7777777777777III77777777777777777IIII,         \n"
				+ "          IIIIIIII777IIIIIIIIIIIII777777777IIIIII           \n"
				+ "              IIIIIII     IIIII    IIIIIIIIII,              \n"
				+ "                           ~I:\n";

		//<--------------------------------STAR PICTURE--------------------------->
		top[2] = "                            .,                              \n"
				+ "                           8MMM                             \n"
				+ "                           M: MM                            \n"
				+ "                         .MM   MM                           \n"
				+ "                         MM     MM                          \n"
				+ "                        MM      +M                          \n"
				+ "                      .NM        MM                         \n"
				+ "                      .M:         MM.                       \n"
				+ "                      MM.          MM                       \n"
				+ "                     MM.            MM                      \n"
				+ "                    MM              ,M                      \n"
				+ "                 ..NM                MMM                    \n"
				+ "         .OMMMMMMMMM.                  MMMMMMMMM=  .        \n"
				+ " OMMMMMMMMM+                                  .IMMMMMMMMMO. \n";

		mid[2] = "MM,                      .        .                     ,MM \n"
				+ "7MM                     M M      . M                    MMI \n"
				+ "  MM.                  MM M     M..M                  ~MM   \n"
				+ "    MM                 MMMM     MMMM.                MM     \n"
				+ "     MM               .MMMM     MMMM.              $MM      \n"
				+ "     .=MM.            .MMMM     MMMM              MM        \n"
				+ "        MM             MMMM     MMMM            MMM         \n"
				+ "         .MM            MMM      MMM.         .MM.          \n"
				+ "          .MM+.                              MMN            \n"
				+ "            MM.                             MM.             \n"
				+ "            .MM                             MM              \n"
				+ "             M.                             MM              \n"
				+ "            MM                               M              \n"
				+ "           .MM                               MM             \n";

		bot[2] = "            MM                               MM             \n"
				+ "           .M                                7M             \n"
				+ "           MM             . 8M:               M.            \n"
				+ "          .MM            MMMMMMMMM            MM            \n"
				+ "          .MM         MMMM       MMMM         MM            \n"
				+ "           M.     =MMM+             MMMM.     OM            \n"
				+ "          MM  .MMMM .                 .+MMM.  .M            \n"
				+ "          MMMMMM.                         .MMMMMM           \n"
				+ "           +=                                .MM\n";

	}

	public FormFigure()
	{
		super(1,0);
		key = new int[3];
		key[0] = 0;
		key[1] = 0;
		key[2] = 0;
	}

	public int getCost()
	{
		return cost;
	}

	public int getPrize()
	{
		return prize;
	}

	public void setPrize()
	{
		if(matched())
		{
			prize = 10;
		}
		else
		{
			prize = 0;
		}
	}

	public int pullLever(int setting)
	{
		prize = 0;
		int x = getRandom(3);
		if(setting==0)
		{
			System.out.println(top[x]);
			key[0] = x;
			return x;
		}
		else if(setting==1)
		{
			System.out.println(mid[x]);
			key[1] = x;
			return x;
		}
		else if(setting==2)
		{
			System.out.println(bot[x]);
			key[2] = x;
			return x;
		}
		else
		{
			System.out.println("Invalid lever setting.");
			return -1;
		}
	}

	public void displayInstructions()
	{
		System.out.println();
		System.out.println("Make a mushroom, flower, or star by lining up evey image");
		System.out.println("Press y 3 times to form a figure.");
		System.out.println("Press n to go back.\n");
	}

	private boolean matched()
	{
		return key[0] == key[1] && key[0] == key[2];
	}

}
