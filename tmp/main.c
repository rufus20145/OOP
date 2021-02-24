#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <windows.h>
#include <ctype.h>
#include <string.h>
int main()
{
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    setlocale(LC_ALL, "RUSSIAN");
    char text[] = "", digit;
    int i=0, k=0;
    printf("������� ������ %d.\n", k);
    do
    {
        printf("k=%d\n", k);
        digit = getchar();
        if (digit != '\n')
        {
            text[i]=digit;
        }
        if (digit==' ')
        {
            k++;
            printf("%d\n", k);
        }
        i++;
    } while (digit != '\n');
    //gets(text);
    //scanf("%[^\n]s", text);
    /*for (int i=0; i<strlen(digit); i++)
    {
        if (' '==digit)
            k++;
    }*/
    printf("%d", k);
    return 0;
}
