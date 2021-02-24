/**
 * @file main.c
 * @author rufus20145 (ivan20027749@gmail.com)
 * @brief ДЗ 1: Нужно создать новую строку из заданной, удалив из нее все повторяющиеся символы.
 * @version 0.1
 * @date 2021-02-15
 *
 * @copyright Copyright (c) 2021
 *
 */

#define STRINGSIZE 1024

#include <stdio.h>
#include <string.h>

int main()
{
    int symbols[256], probels = 0, probels1 = 0;
    char string[STRINGSIZE] = "", digit;
    int currDigit = 0;

    for (int i = 0; i < 256; i++)
    {
        symbols[i] = 0;
    }

    do
    {
        digit = getchar();
        if (digit != '\n')
        {
            string[currDigit] = digit;
            symbols[(int)digit]++;
        }
        if (digit == ' ')
        {
            probels1++;
        }
        currDigit++;
    } while (digit != '\n');

    for (int i = 0; i < STRINGSIZE; i++)
    {
        if (' ' == string[i])
        {
            probels++;
        }
    }

    int length = strlen(string);
    for (int i = 0; i < length; i++)
    {
        if (symbols[(int)string[i]] > 1)
        {
            string[i] = '\0';
        }
    }

    for (int i = 0; i < currDigit; i++)
    {
        putchar(string[i]);
    }
    printf("\nNumber of probels: %d and %d and %d\n", symbols[32], probels, probels1);
    return 0;
}
